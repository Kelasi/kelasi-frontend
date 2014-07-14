(ns kelasi-frontend.utilities
  (:require [cljs.core.async :refer [put! chan]]
            [goog.events :as events]))


(defn listen [elem evt & {:keys [prevent-default transform]
                          :or {prevent-default false
                               transform nil}}]
  (let [out (chan)]
    (events/listen elem (name evt)
                   (fn [e]
                     (when prevent-default
                       (.preventDefault e))
                     (put! out
                           (if (ifn? transform)
                             (transform e)
                             e))))
    out))

