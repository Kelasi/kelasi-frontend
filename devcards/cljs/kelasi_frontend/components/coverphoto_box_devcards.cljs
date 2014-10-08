(ns kelasi-frontend.components.coverphoto-box-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [kelasi-frontend.components.coverphoto-box :refer (coverphoto-box)]
            [devcards.core :as dc :include-macros true]))



(defcard coverphoto-box-component
  (dc/om-root-card coverphoto-box {:img "test.png"
                                   :text "test"}))
