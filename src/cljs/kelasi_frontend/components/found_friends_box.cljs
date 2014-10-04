(ns kelasi-frontend.components.found-friends-box
  (:require [om-tools.core :as omtool :include-macros true]
            [om-tools.dom  :as dom    :include-macros true]
            [om.core       :as om     :include-macros true]
            [kelasi-frontend.components.mini-user-card :refer (mini-user-card)]
            [kelasi-frontend.components.user-list-box :refer (user-list-box)]))



(omtool/defcomponentk found-friends-box
  "Second step of registration."
  [[:data ids people on-select] owner state]
  (init-state
    [_]
    {:selected nil})
  (render
    [_]
    (dom/div
      (dom/p "Select your friend:")

      (om/build user-list-box {:ids ids
                               :people people
                               :selected (:selected @state)
                               :on-select #(swap! state assoc :selected %)})

      (when (:selected @state)
        (dom/button
          {:type "button"
           :on-click #(on-select @(:selected @state))}
          "Select")))))
