(ns kelasi-frontend.components.search-page-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [kelasi-frontend.components.search-page :refer (search-page)]
            [kelasi-frontend.state :refer (app-state)]
            [reagent.core :as r]
            [mocks.user :refer (user1 user2 user3)]
            [mocks.timeline :refer (timeline1 timeline2 timeline3)]
            [devcards.core :as dc :include-macros true]))



(def timelines [timeline1 timeline2 timeline3])
(def users [user1 user2 user3])
(def elem
  [search-page
   {:all-users (zipmap (mapv :id users) users)
    :current-user user1} ;users
   (zipmap (mapv :id timelines) timelines) ;all-timelines
   {:people ["2" "3" "4"]
    :timelines ["1" "2" "3"]}]) ;search

(defcard search-page-component
  (dc/react-card (r/as-element elem)))
