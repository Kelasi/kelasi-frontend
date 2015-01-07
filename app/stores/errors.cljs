(ns stores.errors
  (:require-macros [cljs.core.async.macros :refer (go)])
  (:require [stores.core :refer (store set-in!)]
            [dispatcher.core :refer (process)]
            [cljs.core.async :refer (mult)]))



;; Store

(def errors (store [:errors]))



;; Responces

(defmulti <response (fn [action _] action))

(defmethod <response :default
  [_ _]
  (go nil))

(defmethod <response :wrong-login
  [_ _]
  (set-in! errors [:login] :wrong-login)
  (go nil))

(defmethod <response :net-error
  [_ {:keys [orig]}]
  (set-in! errors [:net-error] orig)
  (go nil))



;; Main loop

(def done
  "Done processing these actions"
  (mult (process <response)))
