(ns kelasi-frontend.dispatcher
  (:require [cljs.core.async :refer (put! chan mult)]))



(def ^:private ch (chan))

(def actions
  "The mult(iplication) of actions channel"
  (mult ch))

(defn dispatch
  "Put the action in the actions channel"
  [data]
  (put! ch data))
