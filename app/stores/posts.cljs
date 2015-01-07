(ns stores.posts
  (:require-macros [cljs.core.async.macros :refer (go)])
  (:require [stores.core :refer (store set-in!)]
            [dispatcher.core :refer (process )]
            [backend.session :as session]
            [backend.posts   :as posts-be]
            [cljs.core.async :refer (mult)]))



;; Store

(def posts (store [:posts]))



;; Action response functions

(defmulti <response (fn [action _] action))

(defmethod <response :default
  [_ _]
  (go nil))

(defmethod <response :new-post
  [_ {:keys [timeline-id parent-id body]}]
  (posts-be/create timeline-id parent-id body)
  (go nil))

(defmethod <response :load-post
  [_ {{:keys [timeline-id parent-id] :as post} :post}]
  (let [timeline-posts (get @posts timeline-id ())
        timeline-posts (if (= "0" parent-id)
                         (cons post timeline-posts)
                         (let [;Split timeline-posts at parent-id
                               [head-posts [parent-post & tail-posts]]
                               (split-with #(not= parent-id (:id %))
                                           timeline-posts)

                               parent-post (->> (get parent-post :replies ())
                                                (cons post)
                                                (assoc parent-post :replies))]
                           (concat head-posts (list parent-post) tail-posts)))]
    (swap! posts assoc timeline-id timeline-posts))
  (go nil))



;; The main loop to listen to actions

(def done
  "The mult of processed actions"
  (mult (process <response)))
