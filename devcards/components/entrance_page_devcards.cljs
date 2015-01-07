(ns components.entrance-page-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [components.entrance-page :refer (entrance-page)]
            [state :refer (app-state)]
            [reagent.core :as r]
            [mocks.user :refer (user1)]
            [devcards.core :as dc :include-macros true]))



(def elem
  [entrance-page
   {:all-users {(:id user1) user1}} ;users
   {:people [(:id user1)]} ;search
   {}]) ;errors

(defcard entrance-page-component
  (dc/react-card (r/as-element elem)))
