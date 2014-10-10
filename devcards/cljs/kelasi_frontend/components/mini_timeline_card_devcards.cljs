(ns kelasi-frontend.components.mini-timeline-card-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [kelasi-frontend.components.mini-timeline-card
             :refer (mini-timeline-card)]
            [mocks.user :refer (user1)]
            [mocks.timeline :refer (timeline1)]
            [devcards.core :as dc :include-macros true]))



(def mini-state (atom {:timeline timeline1
                       :admin user1
                       :on-click #(pr "Timeline " timeline1 " clicked.")}))

(defcard mini-timeline-card-component
  (dc/om-root-card mini-timeline-card mini-state))
