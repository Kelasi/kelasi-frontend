(ns kelasi-frontend.backend.session
  (:require-macros [cljs.core.async.macros :refer (go)])
  (:require [kelasi-frontend.backend.core :refer (send)]
            [cljs.core.async :refer (<!)]))



(defn login
  "Try to login with server"
  [username password]
  (go (let [request (send "POST"
                          "/api_/session.json"
                          {:username username
                           :password password})
            respond (<! request)]
        (print respond))))
