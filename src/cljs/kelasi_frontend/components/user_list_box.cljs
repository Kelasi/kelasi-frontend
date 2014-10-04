(ns kelasi-frontend.components.user-list-box
  (:require [om-tools.core :as omtool :include-macros true]
            [om-tools.dom  :as dom    :include-macros true]
            [om.core       :as om     :include-macros true]
            [kelasi-frontend.components.mini-user-card :refer (mini-user-card)]
            #_[kelasi-frontend.actions :refer (select-introducer)]))



(omtool/defcomponentk user-list-box
  "A list of users"
  [[:data ids people selected on-select] owner state]
  (render
    [_]
    (dom/div
      (for [fid ids
            :let [f (get people fid)]]
        (om/build mini-user-card {:selected (= f selected)
                                  :user f
                                  :on-click #(on-select f)})))))
