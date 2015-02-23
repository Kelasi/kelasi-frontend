(ns widgets.coverphoto-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [widgets.coverphoto :refer (coverphoto)]
            [reagent.core :as r]
            [devcards.core :as dc :include-macros true]))



(defcard coverphoto-widget
  (dc/react-card (r/as-element (coverphoto "test.png" "test"))))
