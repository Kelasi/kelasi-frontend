(ns kelasi-frontend.components.timeline-list-box
  (:require [om-tools.core :as omtool :include-macros true]
            [om-tools.dom  :as dom    :include-macros true]
            [om.core       :as om     :include-macros true]
            [kelasi-frontend.components.mini-timeline-card
             :refer (mini-timeline-card)]))



(omtool/defcomponentk timeline-list-box
  "A list of timelines"
  [[:data ids timelines people on-select]]
  (render
    [_]
    (dom/div
      (for [tid ids
            :let [t (get timelines tid)
                  a (get people (:admin-id t))]]
        (om/build mini-timeline-card {:timeline t
                                      :admin a
                                      :on-click #(on-select t)})))))
