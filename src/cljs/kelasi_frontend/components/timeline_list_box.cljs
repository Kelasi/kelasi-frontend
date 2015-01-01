(ns kelasi-frontend.components.timeline-list-box
  (:require [kelasi-frontend.components.mini-timeline-card
             :refer (mini-timeline-card)]))



(defn timeline-list-box
  "A list of timelines"
  [ids timelines people on-select]
  [:div
   (for [tid ids
         :let [t (get timelines tid)
               a (get people (:admin-id t))]]
     [mini-timeline-card t a #(on-select t)])])
