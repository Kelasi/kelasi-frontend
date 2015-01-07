(ns kelasi-frontend.components.post-list
  (:require [kelasi-frontend.components.post-box :refer (post-box)]))



(defn post-list
  "List of timeline posts"
  [posts all-users]
  [:div
   (for [post posts]
     [post-box post all-users])])
