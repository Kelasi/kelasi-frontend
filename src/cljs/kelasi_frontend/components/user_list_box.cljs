(ns kelasi-frontend.components.user-list-box
  (:require [om-tools.core :as omtool :include-macros true]
            [om-tools.dom  :as dom    :include-macros true]
            [om.core       :as om     :include-macros true]
            [reagent.core :as r]
            [kelasi-frontend.components.mini-user-card :refer (mini-user-card)]))



(omtool/defcomponentk user-list-box
  "A list of users"
  [[:data ids people selected on-select] owner state]
  (render
    [_]
    (dom/div
      (for [fid ids
            :let [f (get people fid)]]
        (r/as-element [mini-user-card (= f selected) #(on-select f) f])))))
