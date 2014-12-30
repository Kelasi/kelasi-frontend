(ns kelasi-frontend.routes
  (:require [kelasi-frontend.actions :refer (change-page)]
            [router.core :as router :include-macros true]
            [kelasi-frontend.components.entrance-page :refer (entrance-page)]
            [kelasi-frontend.components.notfound-page :refer (notfound-page)]))



(router/match "/" entrance-page)
(router/match "/*path" notfound-page)



(router/config!)
(router/set-callback!
  (fn [arg]
    (change-page {:source ::location
                  :page (:value arg)
                  :params (:params arg)})))
