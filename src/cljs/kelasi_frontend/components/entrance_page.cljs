(ns kelasi-frontend.components.entrance-page
  (:require [kelasi-frontend.components.login-signup-box :refer (login-signup-box)]
            [kelasi-frontend.components.search-box :refer (search-box)]))



(omtool/defcomponentk entrance-page
  "Entrance page"
  [search users errors]
  [:div
   [:div {:style {:width "30%"
                  :float "left"}}
    [login-signup-box search users errors]]

   [search-box]

   [:br {:style {:clear "both"}}]])
