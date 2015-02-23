(ns components.user-list-box
  (:require [widgets.media :refer (media)]))



(defn user-list-box
  "A list of users"
  [ids people selected on-select]
  [:div
   (for [fid ids
         :let [f (get people fid)]]
     [:div {:style {:backgroundColor (if (= f selected)
                                       "#333"
                                       "#fff")}}
      [media (:img f) (:full-name f) #(on-select f)]])])
