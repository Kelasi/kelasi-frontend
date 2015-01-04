(ns kelasi-frontend.components.root
  (:require [reagent.core :as r]))



(defn root [data]
  (let [page (get-in @data [:routes :current-page])]
    (if (:page page)
      [(:page page) @data {:opts {:params (:params page)}}]
      [:div "Loading..."])))
