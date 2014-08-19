(ns kelasi-frontend.components.login-box-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [kelasi-frontend.components.login-box :refer (login-box)]
            [kelasi-frontend.state :refer (app-state)]
            [devcards.core :as dc :include-macros true]))

(defcard global-state
  (dc/edn-card @app-state))

(defcard login-box-component
  (dc/om-root-card login-box {}))

(defcard login-box-component-wrong-login-state
  (dc/om-root-card login-box {:errors {:login :wrong-login}}))
