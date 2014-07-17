(ns kelasi-frontend.dispatcher
  (:require-macros [cljs.core.async.macros :refer (go)])
  (:require [cljs.core.async :refer (>! alts! chan)]))


(def listening-channels (atom #{}))

(defn create-chan []
  (let [ch (chan)]
    (swap! listening-channels conj ch)
    ch))

(defn drop-chan [ch]
  (swap! listening-channels disj ch)
  ch)

(defn dispatch [data]
  (doseq [ch @listening-channels]
    (go (>! ch data))))
