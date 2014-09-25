(ns kelasi-frontend.components.signup-progress-breadcrumb
  (:require [om-tools.core :as omtool :include-macros true]
            [om-tools.dom  :as dom    :include-macros true]))



(omtool/defcomponentk signup-progress-breadcrumb
  "A breadcrumb to show the progress in signup process"
  [[:data stage on-click] owner state]
  (render
    [_]
    (dom/div
      (dom/span
        {style {:backgroundColor (if (>= stage 1)
                                   "#333"
                                   "#fff")}}
        (dom/a
          {:href ""
           :on-click (fn [ev] (.preventDefault ev) (on-click 1))}
          "Stage 1"))
      (dom/span
        {style {:backgroundColor (if (>= stage 2)
                                   "#333"
                                   "#fff")}}
        (dom/a
          {:href ""
           :on-click (fn [ev] (.preventDefault ev) (on-click 2))}
          "Stage 2"))
      (dom/span
        {style {:backgroundColor (if (>= stage 3)
                                   "#333"
                                   "#fff")}}
        (dom/a
          {:href ""
           :on-click (fn [ev] (.preventDefault ev) (on-click 3))}
          "Stage 3")))))
