(ns stores.search
  (:require-macros [cljs.core.async.macros :refer (go)])
  (:require [stores.core :refer (store set-in!)]
            [dispatcher.core :refer (process )]
            [backend.search :as search]
            [cljs.core.async :refer (mult)]))



;; Store

(def search (store [:search]))



;; Action response functions

(defmulti <response (fn [action _] action))

(defmethod <response :default
  [_ _]
  (go nil))

(defmethod <response :search-introducer
  [_ {:keys [firstname lastname university]}]
  (search/people firstname lastname university)
  (go nil))

(defmethod <response :load-search-result
  [_ {:keys [category result]}]
  (set-in! search [category] result)
  (go nil))

(defmethod <response :search-all
  [_ {:keys [q]}]
  (search/all q)
  (go nil))



;; The main loop to listen to actions

(def done
  "The mult of processed actions"
  (mult (process <response)))
