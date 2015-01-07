(ns components.login-signup-box-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [components.login-signup-box :refer (login-signup-box)]
            [state :refer (app-state)]
            [reagent.core :as r]
            [mocks.user :refer (user1)]
            [devcards.core :as dc :include-macros true]))



(def elem [login-signup-box
           {:all-users {(:id user1) user1}} ;users
           {:people [(:id user1)]} ;search
           {}]) ;errors

(defcard login-signup-box-component
  (dc/react-card (r/as-element elem)))
