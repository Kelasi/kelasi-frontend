(ns kelasi-frontend.utilities
  (:require [cljs.core.async :refer [put! chan]]
            [goog.events :as events]))


(defn listen [elem evt]
  (let [out (chan)]
    (events/listen elem (name evt)
                   #(put! out %))
    out))

