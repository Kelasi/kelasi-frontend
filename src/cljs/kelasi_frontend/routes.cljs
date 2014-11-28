(ns kelasi-frontend.routes
  (:require-macros [secretary.core :refer (defroute)])
  (:require [secretary.core]
            [kelasi-frontend.components.entrance-page :refer (entrance-page)]
            [kelasi-frontend.components.notfound-page :refer (notfound-page)]))



(defroute home-path "/" {:as params}
  [entrance-page params])



(defroute notfound-path "/*path" {:as params}
  [notfound-page params])
