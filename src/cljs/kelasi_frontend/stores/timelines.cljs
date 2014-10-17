(ns kelasi-frontend.stores.timelines
  (:require-macros [cljs.core.async.macros :refer (go)])
  (:require [kelasi-frontend.stores.core :refer (process store set-in!)]
            [kelasi-frontend.backend.timelines :refer (get-one)]
            [cljs.core.async :refer (mult)]))



;; Store

(def timelines (store [:timelines]))



;; State manupulation functions

(defn set-timeline
  "Set the timeline under timelines/all-timelines of app-state"
  [{id :id :as timeline}]
  (set-in! timelines [:all-timelines id] timeline))



;; Action response functions

(defmulti action-response :action)

(defmethod action-response :default
  [_]
  (go nil))

(defmethod action-response :show-timeline
  [{:keys [timeline-id]}]
  (when-not (get-in @timelines [:all-timelines timeline-id])
    (get-one))
  (go nil))

(defmethod action-response :load-timeline
  [{:keys [timeline]}]
  (set-timeline timeline)
  (go nil))



;; The main loop to listen to actions

(def done
  "The mult of processed actions"
  (mult (process action-response)))
