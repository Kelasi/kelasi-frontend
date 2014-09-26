(ns kelasi-frontend.components.found-friends-box
  (:require [om-tools.core :as omtool :include-macros true]
            [om-tools.dom  :as dom    :include-macros true]
            [om.core       :as om     :include-macros true]
            [kelasi-frontend.components.mini-user-card :refer (mini-user-card)]
            #_[kelasi-frontend.actions :refer (select-introducer)]))



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

      (for [fid ids
            :let [f (get people fid)]]
        (om/build mini-user-card {:selected (= f (:selected @state))
                                  :user f
                                  :on-click #(swap! state assoc :selected f)}))

      (when (:selected @state)
        (dom/button
          {:type "button"
           :on-click #(on-select @(:selected @state))}
          "Select")))))
