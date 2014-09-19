(ns kelasi-frontend.components.mini-user-card-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [kelasi-frontend.components.mini-user-card :refer (mini-user-card)]
            [kelasi-frontend.state :refer (app-state)]
            [mocks.user :refer (user1)]
            [devcards.core :as dc :include-macros true]))

(defcard global-state
  (dc/edn-card @app-state))

(def mini-state (atom {:selected false
                       :user user1
                       :on-click (fn []
                                   (swap! mini-state
                                          update-in [:selected]
                                          not))}))

(defcard mini-user-card-component
  (dc/om-root-card mini-user-card mini-state))
