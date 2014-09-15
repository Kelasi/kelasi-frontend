(ns kelasi-frontend.components.find-friends-box-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [kelasi-frontend.components.find-friends-box :refer (find-friends-box)]
            [kelasi-frontend.state :refer (app-state)]
            [devcards.core :as dc :include-macros true]))

(defcard global-state
  (dc/edn-card @app-state))

(defcard find-friends-box-component
  (dc/om-root-card find-friends-box {}))
