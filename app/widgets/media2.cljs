(ns widgets.media2)



(defn media2
  "A card to display an image a text and some info"
  [img text info on-click]
  [:div
   [:div {:on-click on-click}
    [:img {:src img}]
    [:h2 text]]
   info])
