(ns kelasi-frontend.components.root-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [kelasi-frontend.components.root :refer (root)]
            [kelasi-frontend.state :refer (app-state)]
            [kelasi-frontend.components.entrance-page :refer (entrance-page)]
            [reagent.core :as r]
            [devcards.core :as dc :include-macros true]))



(defcard root-component-with-no-page
  (dc/react-card (r/as-element [root (atom {})])))



(def mini-state
  {:errors {}
   :users {}
   :timelines {}
   :search {}})

(def mini-state-entrance
  (merge mini-state
         {:routes
          {:current-page
           {:page entrance-page
            :params {}}}}))

(defcard root-component-with-entrance-page
  (dc/react-card (r/as-element [root (atom mini-state-entrance)])))
