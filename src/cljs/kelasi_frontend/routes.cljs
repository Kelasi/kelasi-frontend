(ns kelasi-frontend.routes
  (:require-macros [secretary.core :refer (defroute)])
  (:require [secretary.core]
            #_[kelasi-frontend.actions :refer (change-page)]))

(defroute home-path "/" []
  (js/console.log "We are at home!"))

(defroute sub-path "/:path" [path]
  (js/console.log "We are at " path))
