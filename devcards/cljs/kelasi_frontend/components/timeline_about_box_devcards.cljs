(ns kelasi-frontend.components.timeline-about-box-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [kelasi-frontend.components.timeline-about-box :refer (timeline-about-box)]
            [devcards.core :as dc :include-macros true]))



(defcard timeline-about-box-component
  (dc/om-root-card timeline-about-box {:title "test"}))
