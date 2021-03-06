(ns backend.core
  (:require [clojure.browser.event :as gevent]
            [clojure.browser.net   :as gnet]
            [cljs.core.async :refer (chan put! close!)]))



(defn send
  "General xhr function to dispatch requests"
  [method url data]
  (let [ch (chan)
        on-success (fn [ev] (put! ch [:success
                                      (.. ev -target getStatus)
                                      (-> ev .-target
                                          .getResponseJson
                                          (js->clj :keywordize-keys true))])
                            (close! ch))
        on-error (fn [ev] (put! ch [:error
                                    (.. ev -target getStatus)
                                    (.. ev -target getResponseText)])
                          (close! ch))
        xhr (gnet/xhr-connection)]
    (gevent/listen xhr "success" on-success)
    (gevent/listen xhr "error" on-error)
    (gnet/transmit xhr url method data)
    ch))
