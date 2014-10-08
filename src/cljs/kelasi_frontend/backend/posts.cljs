(ns kelasi-frontend.backend.posts
  (:require-macros [cljs.core.async.macros :refer (go)])
  (:require [kelasi-frontend.backend.core :refer (send)]
            [kelasi-frontend.actions :as actions]
            [cljs.core.async :refer (<!)]))



(defn create
  "Create new post in server"
  [timeline-id parent-id body]
  (go (let [request (send "POST"
                          (str "/api_/timelines/" timeline-id "/posts.json")
                          {:parent-id parent-id
                           :body body})
            respond (<! request)]
        (case ((juxt first second) respond)
          [:success 200] (let [post (respond 2)]
                           (actions/load-post :source ::create
                                              :post   post))
          (actions/net-error :source ::create
                             :orig   `(create ~timeline-id
                                              ~parent-id
                                              ~body))))))
