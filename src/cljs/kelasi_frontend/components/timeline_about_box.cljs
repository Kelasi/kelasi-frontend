(ns kelasi-frontend.components.timeline-about-box
  (:require [om-tools.core :as omtool :include-macros true]
            [om-tools.dom  :as dom    :include-macros true]))



(omtool/defcomponentk timeline-about-box
  "A box with basic information regarding a timeline"
  [[:data title] owner state]
  (render
    [_]
    (dom/div
      (dom/div "Title"
               (dom/div title)))))
