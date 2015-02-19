(ns pages.timeline
  (:require [components.navbar :refer (navbar)]
            [components.timeline-about-box
             :refer (timeline-about-box)]
            [components.new-post-box :refer (new-post-box)]
            [components.post-list :refer (post-list)]
            [components.coverphoto-box
             :refer (coverphoto-box)]))



(defn timeline
  "Timeline page"
  [users timeline posts]
  [:div
   [navbar (:current-user users)]
   [coverphoto-box (:cover-image timeline) (:title timeline)]
   [timeline-about-box (:title timeline)]
   [new-post-box (:id timeline) "0"]
   [post-list posts (:all-users users)]])
