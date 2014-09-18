(ns kelasi-frontend.components.found-friends-box
  (:require [om-tools.core :as omtool :include-macros true]
            [om-tools.dom  :as dom    :include-macros true]
            [om.core       :as om     :include-macros true]
            [kelasi-frontend.components.mini-user-card :refer (mini-user-card)]
            #_[kelasi-frontend.actions :refer (select-introducer)]))



(omtool/defcomponentk found-friends-box
  "Second step of registration."
  [[:data friends on-select] owner state]
  (init-state
   [_]
   {:selected 0})
  (render
   [_]
   (dom/div
     (dom/p "Select your friend:")

     (for [fi (range (count friends))
           :let [f (nth friends fi)]]
       (om/build mini-user-card {:selected (= fi (:selected @state))
                                 :user f
                                 :on-click #(swap! state assoc :selected fi)}))

     (dom/button
       {:type "button"
        :on-click #(on-select (nth @friends (:selected @state)))}
       "Select"))))
