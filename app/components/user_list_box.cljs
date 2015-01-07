(ns components.user-list-box
  (:require [components.mini-user-card :refer (mini-user-card)]))



(defn user-list-box
  "A list of users"
  [ids people selected on-select]
  [:div
   (for [fid ids
         :let [f (get people fid)]]
     [mini-user-card (= f selected) #(on-select f) f])])
