(ns kelasi-frontend.components.mini-user-card
  (:require [om-tools.core :as omtool :include-macros true]
            [om-tools.dom  :as dom    :include-macros true]))



(omtool/defcomponentk mini-user-card
  "A mini card to display info of a single user."
  [[:data selected on-click user] owner state]
  (render
   [_]
   (dom/div
     {style {:backgroundColor (if selected
                                "#333"
                                "#fff")}}
     (dom/img {:src (:img user)})
     (dom/a
       {:href ""
        :on-click (fn [ev] (.preventDefault ev) (on-click))}
       (:full-name user)))))
