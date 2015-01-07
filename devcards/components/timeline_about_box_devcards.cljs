(ns components.timeline-about-box-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [components.timeline-about-box :refer (timeline-about-box)]
            [reagent.core :as r]
            [devcards.core :as dc :include-macros true]))



(defcard timeline-about-box-component
  (dc/react-card (r/as-element [timeline-about-box "test"])))
