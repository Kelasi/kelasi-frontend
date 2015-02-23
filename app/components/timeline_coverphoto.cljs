(ns components.timeline-coverphoto
  (:require [widgets.coverphoto :refer (coverphoto)]))



(defn timeline-coverphoto
  "Cover photo of timeline page"
  [timeline]
  [coverphoto (:cover-image timeline) (:title timeline)])
