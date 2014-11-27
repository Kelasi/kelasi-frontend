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
