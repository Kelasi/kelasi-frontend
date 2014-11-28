(ns kelasi-frontend.routes
  (:require-macros [secretary.core :refer (defroute)])
  (:require [secretary.core]
            [kelasi-frontend.actions :refer (change-page)]
            [kelasi-frontend.components.entrance-page :refer (entrance-page)]))



(defroute home-path "/" []
  (change-page :source ::router
               :page entrance-page
               :params []))



(defroute notfound-path "/*path" [path]
  (js/console.log "We are at " path))
