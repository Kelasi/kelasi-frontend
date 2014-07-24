(ns kelasi-frontend.components.root-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [kelasi-frontend.components.root :refer (root)]
            [devcards.core :as dc :include-macros true]))

(defcard root-component
  (dc/om-root-card root {:test "Hello World!"}))
