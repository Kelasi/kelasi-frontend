(ns kelasi-frontend.components.timeline-list-box-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [kelasi-frontend.components.timeline-list-box
             :refer (timeline-list-box)]
            [kelasi-frontend.state :refer (app-state)]
            [reagent.core :as r]
            [mocks.user :refer (user1 user2 user3)]
            [mocks.timeline :refer (timeline1 timeline2 timeline3)]
            [devcards.core :as dc :include-macros true]))



(def users [user1 user2 user3])
(def timelines [timeline1 timeline2 timeline3])
(def elem [timeline-list-box
           (mapv :id timelines) ; ids
           (zipmap (mapv :id timelines) timelines) ; timelines
           (zipmap (mapv :id users) users) ; people
           (fn [s] (pr "timeline selected" s))]) ; on-select

(defcard timeline-list-box-component
  (dc/react-card (r/as-element elem)))
