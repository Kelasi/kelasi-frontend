(ns kelasi-frontend.components.new-post-box-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [kelasi-frontend.components.new-post-box :refer (new-post-box)]
            [reagent.core :as r]
            [devcards.core :as dc :include-macros true]))



(defcard new-post-box-component
  (dc/react-card (r/as-element [new-post-box "1" "0"])))
