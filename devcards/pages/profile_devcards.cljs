(ns pages.profile-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [pages.profile :refer (profile)]
            [state :refer (app-state)]
            [reagent.core :as r]
            [mocks.user :refer (user1 user2 user3 user4)]
            [mocks.timeline :refer (timeline1 timeline2 timeline3 timeline4)]
            [devcards.core :as dc :include-macros true]))



(def timelines [timeline1 timeline2 timeline3 timeline4])
(def users [user1 user2 user3 user4])
(def elem
  [profile
   user1 ;user
   {:all-users (zipmap (mapv :id users) users)
    :current-user user1} ;all-users
   (zipmap (mapv :id timelines) timelines)]) ;all-timelines

(defcard profile-page
  (dc/react-card (r/as-element elem)))
