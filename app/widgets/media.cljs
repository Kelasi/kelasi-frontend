(ns widgets.media)



(defn media
  "A mini card to display a small image and a link"
  [img text on-click]
  [:div
   [:img {:src img}]
   [:a {:href "" :on-click #(do (.preventDefault %) (on-click))}
    text]])
