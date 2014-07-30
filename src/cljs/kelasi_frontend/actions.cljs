(ns kelasi-frontend.actions
  (:require [kelasi-frontend.dispatcher :as dispatch]))



(defn try-login
  "View - When user submits login box"
  [src payload]
  (dispatch/dispatch {:source  src
                      :action  :try-login
                      :payload payload}))

(defn load-user
  "Backend - When server send back a logged in user"
  [src payload]
  (dispatch/dispatch {:source src
                      :action :load-user
                      :payload payload}))
