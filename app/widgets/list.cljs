(ns widgets.list
  (:refer-clojure :exclude [list]))



(defn list
  "A list of a widget"
  [lst widget-fn]
  [:div
   (for [item lst]
     (widget-fn item))])
