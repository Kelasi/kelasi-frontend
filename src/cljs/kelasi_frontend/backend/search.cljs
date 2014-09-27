(ns kelasi-frontend.backend.search
  (:require-macros [cljs.core.async.macros :refer (go)])
  (:require [kelasi-frontend.backend.core :refer (send)]
            [kelasi-frontend.actions :as actions]
            [cljs.core.async :refer (<!)]))



(defn people
  "Search for people in server"
  [firstname lastname university]
  (go (let [request (send "POST"
                          "/api_/search/people.json"
                          {:fname   firstname
                           :lname   lastname
                           :uniname university})
            respond (<! request)]
        (condp = ((juxt first second) respond)
          [:success 200] (let [result (respond 2)
                               ids (for [user result]
                                     (do
                                       (actions/load-user :source ::people
                                                          :user   user)
                                       (:id user)))]
                           (actions/load-search-result :source   ::people
                                                       :category :people
                                                       :result   ids))
          (actions/net-error :source ::people
                             :orig   `(people ~firstname
                                              ~lastname
                                              ~university))))))



(defn all
  "Search through all data"
  [query]
  )
