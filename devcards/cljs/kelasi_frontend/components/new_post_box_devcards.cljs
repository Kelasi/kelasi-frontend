(ns kelasi-frontend.components.new-post-box-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [kelasi-frontend.components.new-post-box :refer (new-post-box)]
            [devcards.core :as dc :include-macros true]))



(defcard new-post-box-component
  (dc/om-root-card new-post-box {:timeline-id "1"
                                 :parent-id "0"}))
