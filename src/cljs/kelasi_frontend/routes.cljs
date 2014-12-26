(ns kelasi-frontend.routes
  (:require [router.core :as router :include-macros true]
            [kelasi-frontend.components.entrance-page :refer (entrance-page)]
            [kelasi-frontend.components.notfound-page :refer (notfound-page)]))



;; (router/match "/" entrance-page)
;; (router/match "/*path" notfound-page)
