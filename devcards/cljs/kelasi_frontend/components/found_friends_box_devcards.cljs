(ns kelasi-frontend.components.found-friends-box-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [kelasi-frontend.components.found-friends-box :refer (found-friends-box)]
            [kelasi-frontend.state :refer (app-state)]
            [mocks.user :refer (user1 user2 user3)]
            [devcards.core :as dc :include-macros true]))

(defcard global-state
  (dc/edn-card @app-state))

(def users [user1 user2 user3])
(def state {:ids (mapv :id users)
            :people (zipmap (mapv :id users) users)
            :on-select (fn [s] (pr "Selected:" s))})

(defcard found-friends-box-component
  (dc/om-root-card found-friends-box state))
