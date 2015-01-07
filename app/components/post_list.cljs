(ns components.post-list
  (:require [components.post-box :refer (post-box)]))



(defn post-list
  "List of timeline posts"
  [posts all-users]
  [:div
   (for [post posts]
     [post-box post all-users])])
