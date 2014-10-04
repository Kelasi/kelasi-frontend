(ns kelasi-frontend.components.mini-timeline-box-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [kelasi-frontend.components.mini-timeline-box :refer (mini-timeline-box)]
            [devcards.core :as dc :include-macros true]))

(defcard mini-timeline-box-component
  (dc/om-root-card mini-timeline-box {:title "Timeline Title"
                                      :conver-photo-mini "path/to/cover/photo"
                                      :followers-no "123"
                                      :posts-no "123"
                                      :profile-photo-thumb "path/to/profile/photo"}))
