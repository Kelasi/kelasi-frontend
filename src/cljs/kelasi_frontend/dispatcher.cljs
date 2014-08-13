(ns kelasi-frontend.dispatcher
  (:require [cljs.core.async :refer (put! chan mult tap untap)]))



(def actions-chan
  "The channel to distribute actions"
  (chan))

(def actions-mult
  "The mult(iplication) of actions-chan"
  (mult actions-chan))


(defn create-chan
  "Create a subscription channel to listen to actions"
  []
  (let [ch (chan)]
    (tap actions-mult ch)
    ch))

(defn drop-chan
  "Removes the channel from mult"
  [ch]
  (untap actions-mult ch))

(defn dispatch [data]
  (put! actions-chan data))
