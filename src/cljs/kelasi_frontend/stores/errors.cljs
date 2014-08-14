(ns kelasi-frontend.stores.errors
  (:require-macros [cljs.core.async.macros :refer (go)])
  (:require [kelasi-frontend.stores.core :refer (process store set-in!)]
            [cljs.core.async :refer (mult)]))



;; Store

(def errors (store [:errors]))



;; Responces

(defmulti responce :action)

(defmethod responce :default
  [_]
  (go nil))

(defmethod responce :wrong-login
  [_]
  (set-in! errors [:login] :wrong-login)
  (go nil))

(defmethod responce :net-error
  [{:keys [orig]}]
  (set-in! errors [:net-error] orig)
  (go nil))



;; Main loop

(def done
  "Done processing these actions"
  (mult (process responce)))
