(ns kelasi-frontend.components.navbar-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [kelasi-frontend.components.navbar :refer (navbar)]
            [kelasi-frontend.state :refer (app-state)]
            [mocks.user :refer (user1)]
            [devcards.core :as dc :include-macros true]))

(defcard global-state
  (dc/edn-card @app-state))

(defcard navbar-component
  (dc/om-root-card navbar {:current-user nil}))

(defcard navbar-logged-in-component
  (dc/om-root-card navbar {:current-user user1}))
