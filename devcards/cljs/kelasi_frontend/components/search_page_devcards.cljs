(ns kelasi-frontend.components.search-page-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [kelasi-frontend.components.search-page :refer (search-page)]
            [kelasi-frontend.state :refer (app-state)]
            [mocks.user :refer (user1 user2 user3)]
            [mocks.timeline :refer (timeline1 timeline2 timeline3)]
            [devcards.core :as dc :include-macros true]))



(defcard global-state
  (dc/edn-card @app-state))



(def timelines [timeline1 timeline2 timeline3])
(def users [user1 user2 user3])
(def mini-state
  {:users {:all-users (zipmap (mapv :id users) users)
           :current-user user1}
   :all-timelines (zipmap (mapv :id timelines) timelines)
   :search {:people ["2" "3" "4"]
            :timelines ["1" "2" "3"]}
   })

(defcard search-page-component
  (dc/om-root-card search-page mini-state))
