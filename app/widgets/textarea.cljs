(ns widgets.textarea)



(defn textarea
  "A text area"
  [text]
  [:textarea {:value @text
              :on-change #(reset! text (.-target.value %))}])
