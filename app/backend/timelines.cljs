(ns backend.timelines
  (:require-macros [cljs.core.async.macros :refer (go)])
  (:require [backend.core :refer (send)]
            [actions :as actions]
            [cljs.core.async :refer (<!)]))



(defn get-one
  "Try to get a timeline from server"
  [timeline-id]
  (go (let [request (send "GET"
                          (str "/api_/timelines/" timeline-id ".json")
                          nil)
            respond (<! request)]
        (condp = ((juxt first second) respond)
          [:success 200] (let [timeline (respond 2)]
                           (actions/load-timeline {:source ::get-one
                                                   :timeline timeline}))
          (actions/net-error {:source ::get-one
                              :orig `(get-one ~timeline-id)})))))
