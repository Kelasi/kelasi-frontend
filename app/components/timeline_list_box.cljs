(ns components.timeline-list-box
  (:require [widgets.media :refer (media)]
            [widgets.media2 :refer (media2)]))



(defn timeline-list-box
  "A list of timelines"
  [ids timelines people on-select]
  [:div
   (for [tid ids
         :let [t (get timelines tid)
               a (get people (:admin-id t))]]
     [media2 (:cover-photo-mini t)
             (:title t)
             [media (:img a) (:full-name a) #(on-select t)]
             #(on-select t)])])
