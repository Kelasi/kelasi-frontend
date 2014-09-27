(ns kelasi-frontend.components.search-box-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [kelasi-frontend.components.search-box :refer (search-box)]
            [kelasi-frontend.state :refer (app-state)]
            [devcards.core :as dc :include-macros true]))

(defcard global-state
  (dc/edn-card @app-state))

(defcard search-box-component
  (dc/om-root-card search-box {}))
