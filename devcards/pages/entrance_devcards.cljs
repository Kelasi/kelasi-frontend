(ns pages.entrance-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [pages.entrance :refer (entrance)]
            [state :refer (app-state)]
            [reagent.core :as r]
            [mocks.user :refer (user1)]
            [devcards.core :as dc :include-macros true]))



(def elem
  [entrance
   {:all-users {(:id user1) user1}} ;users
   {:people [(:id user1)]} ;search
   {}]) ;errors

(defcard entrance-page
  (dc/react-card (r/as-element elem)))
