(ns components.coverphoto-box-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [components.coverphoto-box :refer (coverphoto-box)]
            [reagent.core :as r]
            [devcards.core :as dc :include-macros true]))



(defcard coverphoto-box-component
  (dc/react-card (r/as-element (coverphoto-box "test.png" "test"))))
