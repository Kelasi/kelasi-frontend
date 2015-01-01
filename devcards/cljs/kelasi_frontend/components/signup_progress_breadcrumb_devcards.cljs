(ns kelasi-frontend.components.signup-progress-breadcrumb-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [kelasi-frontend.components.signup-progress-breadcrumb
             :refer (signup-progress-breadcrumb)]
            [kelasi-frontend.state :refer (app-state)]
            [reagent.core :as r]
            [devcards.core :as dc :include-macros true]))



(defcard signup-progress-breadcrumb-component
  (dc/react-runner-card (fn [s]
                          (r/as-element
                            [signup-progress-breadcrumb @s #(reset! s %)]))
                        {:initial-state 1}))
