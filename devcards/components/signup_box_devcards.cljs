(ns components.signup-box-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [components.signup-box :refer (signup-box)]
            [state :refer (app-state)]
            [reagent.core :as r]
            [mocks.user :refer (user1)]
            [devcards.core :as dc :include-macros true]))



(defcard signup-box-component
  (dc/react-card (r/as-element [signup-box [(:id user1)] {(:id user1) user1}])))
