(ns mocks.location
  (:require [kelasi-frontend.location :refer (current-route change-route)]))



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
    (change-route loc)))

(defn stub
  "Stub out the change-route"
  []
  (.stub js/sinon kelasi-frontend.location "change_route"))

(defn unstub
  "Restore the change-route"
  []
  (.restore change-route))

(defn went-to?
  "Return whether or not went to a specified path"
  [path]
  (.calledWith change-route path))
