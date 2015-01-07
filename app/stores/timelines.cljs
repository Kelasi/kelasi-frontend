(ns stores.timelines
  (:require-macros [cljs.core.async.macros :refer (go)])
  (:require [stores.core :refer (store set-in!)]
            [dispatcher.core :refer (process )]
            [backend.timelines :refer (get-one)]
            [cljs.core.async :refer (mult)]))



;; Store

(def timelines (store [:timelines]))



;; State manupulation functions

(defn set-timeline
  "Set the timeline under timelines/all-timelines of app-state"
  [{id :id :as timeline}]
  (set-in! timelines [:all-timelines id] timeline))



;; Action response functions

(defmulti <respons (fn [action _] action))

(defmethod <respons :default
  [_ _]
  (go nil))

(defmethod <respons :show-timeline
  [_ {:keys [timeline-id]}]
  (when-not (get-in @timelines [:all-timelines timeline-id])
    (get-one timeline-id))
  (go nil))

(defmethod <respons :load-timeline
  [_ {:keys [timeline]}]
  (set-timeline timeline)
  (go nil))



;; The main loop to listen to actions

(def done
  "The mult of processed actions"
  (mult (process <respons)))
