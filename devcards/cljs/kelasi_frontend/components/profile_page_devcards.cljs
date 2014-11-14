(ns kelasi-frontend.components.profile-page-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [kelasi-frontend.components.profile-page :refer (profile-page)]
            [kelasi-frontend.state :refer (app-state)]
            [mocks.user :refer (user1 user2 user3 user4)]
            [mocks.timeline :refer (timeline1 timeline2 timeline3 timeline4)]
            [devcards.core :as dc :include-macros true]))



(defcard global-state
  (dc/edn-card @app-state))



(def timelines [timeline1 timeline2 timeline3 timeline4])
(def users [user1 user2 user3 user4])
(def mini-state
  {:user user1
   :users {:all-users (zipmap (mapv :id users) users)
           :current-user user1}
   :all-timelines (zipmap (mapv :id timelines) timelines)})

(defcard profile-page-component
  (dc/om-root-card profile-page mini-state))
