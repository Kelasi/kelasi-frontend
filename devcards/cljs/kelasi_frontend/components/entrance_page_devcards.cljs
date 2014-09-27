(ns kelasi-frontend.components.entrance-page-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [kelasi-frontend.components.entrance-page :refer (entrance-page)]
            [kelasi-frontend.state :refer (app-state)]
            [mocks.user :refer (user1)]
            [devcards.core :as dc :include-macros true]))

(defcard global-state
  (dc/edn-card @app-state))

(def mini-state
  {:errors {}
   :users {:all-users {(:id user1) user1}}
   :search {:people [(:id user1)]}
   })

(defcard entrance-page-component
  (dc/om-root-card entrance-page mini-state))
