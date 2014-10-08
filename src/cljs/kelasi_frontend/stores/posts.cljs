(ns kelasi-frontend.stores.posts
  (:require-macros [cljs.core.async.macros :refer (go)])
  (:require [kelasi-frontend.stores.core :refer (process store set-in!)]
            [kelasi-frontend.backend.session :as session]
            [kelasi-frontend.backend.posts   :as posts-be]
            [cljs.core.async :refer (mult)]))



;; Store

(def posts (store [:posts]))



;; Action response functions

(defmulti response :action)

(defmethod response :default
  [_]
  (go nil))

(defmethod response :new-post
  [{:keys [timeline-id parent-id body]}]
  (posts-be/create timeline-id parent-id body)
  (go nil))



;; The main loop to listen to actions

(def done
  "The mult of processed actions"
  (mult (process response)))
