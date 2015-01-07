(ns mocks.location
  (:require [router.core :refer (current-route navigate!)]))



(def mem (atom ()))

(defn save
  "Save current location"
  []
  (swap! mem conj (current-route)))

(defn restore
  "Restore previous location"
  []
  (when-let [loc (first @mem)]
    (swap! mem next)
    (navigate! loc)))

(defn stub
  "Stub out the navigate!"
  []
  (.stub js/sinon router.core "navigate_BANG_"))

(defn unstub
  "Restore the navigate!"
  []
  (.restore navigate!))

(defn went-to?
  "Return whether or not went to a specified path"
  [path]
  (.calledWith navigate! path))
