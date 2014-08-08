(ns kelasi-frontend.components.login-box-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [kelasi-frontend.components.login-box :refer (login-box)]
            [devcards.core :as dc :include-macros true]))

(defcard login-box-component
  (dc/om-root-card login-box {}))
