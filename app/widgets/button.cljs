(ns widgets.button)



(defn button
  "A general button widget"
  [lbl on-click]
  [:button {:type "button"
            :on-click on-click}
   lbl])
