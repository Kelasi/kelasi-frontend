(ns kelasi-frontend.components.login-signup-box-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [kelasi-frontend.components.login-signup-box :refer (login-signup-box)]
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

(defcard login-box-component
  (dc/om-root-card login-signup-box mini-state))
