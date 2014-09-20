(ns kelasi-frontend.backend.users
  (:require-macros [cljs.core.async.macros :refer (go)])
  (:require [kelasi-frontend.backend.core :refer (send)]
            [kelasi-frontend.actions :as actions]
            [cljs.core.async :refer (<!)]))



(defn create
  "Create new user in server"
  [username firstname lastname university password])
