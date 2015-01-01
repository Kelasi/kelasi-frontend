(ns kelasi-frontend.components.entrance-page
  (:require [om-tools.core :as omtool :include-macros true]
            [om-tools.dom  :as dom    :include-macros true]
            [om.core       :as om     :include-macros true]
            [reagent.core :as r]
            [kelasi-frontend.components.login-signup-box :refer (login-signup-box)]
            [kelasi-frontend.components.search-box :refer (search-box)]))



(omtool/defcomponentk entrance-page
  "Entrance page"
  [[:data errors search users] owner state]
  (render
    [_]
    (dom/div
      (dom/div {:style {:width "30%"
                        :float "left"}}
               (om/build login-signup-box {:errors errors
                                           :search search
                                           :users users}))

      (r/as-element [search-box])

      (dom/br {:style {:clear "both"}}))))
