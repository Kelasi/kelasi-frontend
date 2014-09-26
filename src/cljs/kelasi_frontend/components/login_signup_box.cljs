(ns kelasi-frontend.components.login-signup-box
  (:require [om-tools.core :as omtool :include-macros true]
            [om-tools.dom  :as dom    :include-macros true]
            [om.core       :as om     :include-macros true]
            [kelasi-frontend.components.login-box :refer (login-box)]
            [kelasi-frontend.components.signup-box :refer (signup-box)]
            [kelasi-frontend.actions :refer (try-login)]))



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
        (om/build login-box {:errors errors}))

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
