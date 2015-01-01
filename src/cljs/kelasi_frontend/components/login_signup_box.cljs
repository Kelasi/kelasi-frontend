(ns kelasi-frontend.components.login-signup-box
  (:require [om-tools.core :as omtool :include-macros true]
            [om-tools.dom  :as dom    :include-macros true]
            [om.core       :as om     :include-macros true]
            [reagent.core :as r]
            [kelasi-frontend.components.login-box :refer (login-box)]
            [kelasi-frontend.components.signup-box :refer (signup-box)]))



(omtool/defcomponentk login-signup-box
  "First page's sidebar"
  [[:data errors search users] owner state]
  (init-state
    [_]
    {:position :up})
  (render
    [_]
    (dom/div
      (when (= :up (:position @state))
        (r/as-element [login-box errors]))

      (dom/a {:href ""
              :on-click (fn [ev]
                          (.preventDefault ev)
                          (swap! state
                                 update-in [:position]
                                 #(if (= % :up)
                                    :down
                                    :up)))}
             "Swap login/signup")

      (when (= :down (:position @state))
        (om/build signup-box {:search search
                              :users users})))))
