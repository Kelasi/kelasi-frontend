(ns pages.entrance
  (:require [components.login-signup-box :refer (login-signup-box)]
            [components.search-box :refer (search-box)]))



(defn entrance
  "Entrance page"
  [search users errors]
  [:div
   [:div {:style {:width "30%"
                  :float "left"}}
    [login-signup-box search users errors]]

   [search-box]

   [:br {:style {:clear "both"}}]])
