(ns kelasi-frontend.components.signup-box-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [kelasi-frontend.components.signup-box :refer (signup-box)]
            [kelasi-frontend.state :refer (app-state)]
            [reagent.core :as r]
            [mocks.user :refer (user1)]
            [devcards.core :as dc :include-macros true]))



(defcard signup-box-component
  (dc/react-card [signup-box [(:id user1)] {(:id user1) user1}]))
