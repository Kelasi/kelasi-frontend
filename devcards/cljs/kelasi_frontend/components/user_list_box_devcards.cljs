(ns kelasi-frontend.components.user-list-box-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [kelasi-frontend.components.user-list-box :refer (user-list-box)]
            [kelasi-frontend.state :refer (app-state)]
            [mocks.user :refer (user1 user2 user3)]
            [devcards.core :as dc :include-macros true]))

(defcard global-state
  (dc/edn-card @app-state))

(def users [user1 user2 user3])
(def state (atom {:ids (mapv :id users)
                  :people (zipmap (mapv :id users) users)
                  :selected nil
                  :on-select (fn [s] (swap! state assoc :selected s))}))

(defcard user-list-box-component
  (dc/om-root-card user-list-box state))
