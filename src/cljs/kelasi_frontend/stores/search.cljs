(ns kelasi-frontend.stores.search
  (:require-macros [cljs.core.async.macros :refer (go)])
  (:require [kelasi-frontend.stores.core :refer (process store set-in!)]
            [kelasi-frontend.backend.search :as search]
            [cljs.core.async :refer (mult)]))



;; Store

(def search (store [:search]))



;; Action response functions

(defmulti response :action)

(defmethod response :default
  [_]
  (go nil))

(defmethod response :search-introducer
  [{:keys [firstname lastname university]}]
  (search/people firstname lastname university)
  (go nil))



;; The main loop to listen to actions

(def done
  "The mult of processed actions"
  (mult (process response)))
