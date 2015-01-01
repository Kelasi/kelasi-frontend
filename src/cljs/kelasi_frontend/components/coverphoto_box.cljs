(ns kelasi-frontend.components.coverphoto-box)



(defn coverphoto-box
  "A cover photo component"
  [img text]
  [:div
   [:img {:style {:width "100%"
                  :height "240px"}
          :src img}]
   [:h2 {:style {:margin "-50px 0 0 20px"}} text]])
