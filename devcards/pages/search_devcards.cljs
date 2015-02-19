(ns pages.search-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [pages.search :refer (search)]
            [state :refer (app-state)]
            [reagent.core :as r]
            [mocks.user :refer (user1 user2 user3)]
            [mocks.timeline :refer (timeline1 timeline2 timeline3)]
            [devcards.core :as dc :include-macros true]))



(def timelines [timeline1 timeline2 timeline3])
(def users [user1 user2 user3])
(def elem
  [search
   {:people ["2" "3" "4"]
    :timelines ["1" "2" "3"]} ;search
   {:all-users (zipmap (mapv :id users) users)
    :current-user user1} ;users
   (zipmap (mapv :id timelines) timelines)]) ;all-timelines

(defcard search-page
  (dc/react-card (r/as-element elem)))
