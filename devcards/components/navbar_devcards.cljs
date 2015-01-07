(ns kelasi-frontend.components.navbar-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [kelasi-frontend.components.navbar :refer (navbar)]
            [kelasi-frontend.state :refer (app-state)]
            [reagent.core :as r]
            [mocks.user :refer (user1)]
            [devcards.core :as dc :include-macros true]))



(defcard navbar-component
  (dc/react-card (r/as-element [navbar nil])))

(defcard navbar-logged-in-component
  (dc/react-card (r/as-element [navbar user1])))
