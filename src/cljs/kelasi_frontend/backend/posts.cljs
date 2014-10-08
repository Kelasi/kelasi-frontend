(ns kelasi-frontend.backend.posts
  (:require-macros [cljs.core.async.macros :refer (go)])
  (:require [kelasi-frontend.backend.core :refer (send)]
            [kelasi-frontend.actions :as actions]
            [cljs.core.async :refer (<!)]))



(defn create
  "Create new post in server"
  [timeline-id parent-id body]
  )
