(ns kelasi-frontend.components.signup-final-box-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [kelasi-frontend.components.signup-final-box :refer (signup-final-box)]
            [kelasi-frontend.state :refer (app-state)]
            [mocks.user :refer (user1)]
            [devcards.core :as dc :include-macros true]))

(defcard global-state
  (dc/edn-card @app-state))

(defcard signup-final-box-component
  (dc/om-root-card signup-final-box {:introducer user1}))
