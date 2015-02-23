(ns widgets.input)



(defn input
  "A general input widget"
  [type val-atom]
  [:input {:type (name type)
           :value @val-atom
           :on-change #(reset! val-atom (.-target.value %))}])
