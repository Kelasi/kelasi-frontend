(ns kelasi-frontend.components.signup-final-box-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [kelasi-frontend.components.signup-final-box :refer (signup-final-box)]
            [kelasi-frontend.state :refer (app-state)]
            [reagent.core :as r]
            [mocks.user :refer (user1)]
            [devcards.core :as dc :include-macros true]))



(defcard signup-final-box-component
  (dc/react-card (r/as-element [signup-final-box user1])))
