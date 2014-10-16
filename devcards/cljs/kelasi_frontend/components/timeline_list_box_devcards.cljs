(ns kelasi-frontend.components.timeline-list-box-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [kelasi-frontend.components.timeline-list-box
             :refer (timeline-list-box)]
            [kelasi-frontend.state :refer (app-state)]
            [mocks.user :refer (user1 user2 user3)]
            [mocks.timeline :refer (timeline1 timeline2 timeline3)]
            [devcards.core :as dc :include-macros true]))

(defcard global-state
  (dc/edn-card @app-state))

(def users [user1 user2 user3])
(def timelines [timeline1 timeline2 timeline3])
(def state (atom {:ids (mapv :id timelines)
                  :timelines (zipmap (mapv :id timelines) timelines)
                  :people (zipmap (mapv :id users) users)
                  :on-select (fn [s] (pr "timeline selected" s))}))

(defcard timeline-list-box-component
  (dc/om-root-card timeline-list-box state))
