(ns kelasi-frontend.components.login-box-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [kelasi-frontend.components.login-box :refer (login-box)]
            [kelasi-frontend.state :refer (app-state)]
            [reagent.core :as r]
            [devcards.core :as dc :include-macros true]))

(defcard login-box-component
  (dc/react-card (r/as-element [login-box {}])))

(defcard login-box-component--wrong-login-state
  (dc/react-card (r/as-element
                   [login-box {:login :wrong-login}])))
