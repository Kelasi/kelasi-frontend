(ns kelasi-frontend.components.mini-user-card-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [kelasi-frontend.components.mini-user-card :refer (mini-user-card)]
            [kelasi-frontend.state :refer (app-state)]
            [reagent.core :as r]
            [mocks.user :refer (user1)]
            [devcards.core :as dc :include-macros true]))



(defcard mini-user-card-component--not-selected
  (dc/react-card (r/as-element
                   [mini-user-card false #(pr "clicked") user1])))



(defcard mini-user-card-component--selected
  (dc/react-card (r/as-element
                   [mini-user-card true #(pr "clicked") user1])))
