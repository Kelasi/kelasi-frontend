(ns widgets.labeled-input)



(defn labeled-input
  "A text input widget with label"
  [label val-atom]
  [:div
    label
    [:input {:type "text"
             :value val-atom
             :on-change #(reset! val-atom (.-target.value %))}]])
