(ns kelasi-frontend.components.timeline-page
  (:require [kelasi-frontend.components.navbar :refer (navbar)]
            [kelasi-frontend.components.timeline-about-box
             :refer (timeline-about-box)]
            [kelasi-frontend.components.new-post-box :refer (new-post-box)]
            [kelasi-frontend.components.post-list :refer (post-list)]
            [kelasi-frontend.components.coverphoto-box
             :refer (coverphoto-box)]))



(defn timeline-page
  "Timeline page"
  [users timeline posts]
  [:div
   [navbar (:current-user users)]
   [coverphoto-box (:cover-image timeline) (:title timeline)]
   [timeline-about-box (:title timeline)]
   [new-post-box (:id timeline) "0"]
   [post-list posts (:all-users users)]])
