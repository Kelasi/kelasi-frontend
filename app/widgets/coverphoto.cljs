(ns widgets.coverphoto)



(defn coverphoto
  "A cover photo component"
  [img text]
  [:div {:style {:position "relative"}}
   [:img {:style {:width "100%"
                  :height "240px"}
          :src img}]
   [:h2 {:style {:position "absolute"
                 :left 20
                 :bottom 15}}
    text]])
