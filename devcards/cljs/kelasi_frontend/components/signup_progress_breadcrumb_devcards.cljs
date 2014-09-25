(ns kelasi-frontend.components.signup-progress-breadcrumb-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [kelasi-frontend.components.signup-progress-breadcrumb
             :refer (signup-progress-breadcrumb)]
            [kelasi-frontend.state :refer (app-state)]
            [devcards.core :as dc :include-macros true]))

(defcard global-state
  (dc/edn-card @app-state))

(def mini-state (atom {:stage 1
                       :on-click (fn [stage]
                                   (swap! mini-state
                                          assoc :stage
                                          stage))}))

(defcard signup-progress-breadcrumb-component
  (dc/om-root-card signup-progress-breadcrumb mini-state))
