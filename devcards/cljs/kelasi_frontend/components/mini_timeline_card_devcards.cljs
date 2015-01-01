(ns kelasi-frontend.components.mini-timeline-card-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [kelasi-frontend.components.mini-timeline-card
             :refer (mini-timeline-card)]
            [mocks.user :refer (user1)]
            [mocks.timeline :refer (timeline1)]
            [reagent.core :as r]
            [devcards.core :as dc :include-macros true]))



(defcard mini-timeline-card-component
  (dc/react-card (r/as-element
                   [mini-timeline-card timeline1 user1
                    #(pr "Timeline " timeline1 " clicked.")])))
