(ns kelasi-frontend.components.navbar
  (:require [om-tools.core :as omtool :include-macros true]
            [om-tools.dom  :as dom    :include-macros true]
            [kelasi-frontend.actions :refer (search-all
                                              show-self-profile)]))



(omtool/defcomponentk navbar
  "The main navbar at the top of all pages"
  [[:data current-user] owner state]
  (init-state
    [_]
    {:search ""})
  (render
    [_]
    (dom/div
      {:style {:width "100%"
               :backgroundColor "#cc9"}}

      (dom/span "Kelasi")

      (dom/input {:type "text"
                  :value (:search @state)
                  :on-change #(swap! state assoc :search (.. % -target -value))
                  :on-key-press #(search-all :source ::navbar
                                             :q (:search @state))})

      (when current-user
        (dom/a {:href ""
                :style {:float "right"}
                :on-click (fn [ev]
                            (.preventDefault ev)
                            (show-self-profile :source ::navbar))}
               (:full-name current-user))))))
