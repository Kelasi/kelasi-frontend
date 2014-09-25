(ns kelasi-frontend.components.signup-box-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [kelasi-frontend.components.signup-box :refer (signup-box)]
            [kelasi-frontend.state :refer (app-state)]
            [mocks.user :refer (user1)]
            [devcards.core :as dc :include-macros true]))

(defcard global-state
  (dc/edn-card @app-state))

(defcard signup-box-component
  (dc/om-root-card signup-box {:friends [user1]}))
