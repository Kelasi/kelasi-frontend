(ns kelasi-frontend.backend.core
  (:require [clojure.browser.event :as gevent]
            [clojure.browser.net   :as gnet]
            [cljs.core.async :refer (chan put! close!)]))



(defn send
  "General xhr function to dispatch requests"
  [method url data]
  (let [ch (chan)
        on-success (fn [ev] (put! ch [:success ev])
                            (close! ch))
        on-error (fn [ev] (put! ch [:error ev])
                          (close! ch))
        xhr (gnet/xhr-connection)]
    (gevent/listen xhr "error" on-error)
    (gevent/listen xhr "success" on-success)
    (gnet/transmit xhr url method data)
    ch))
