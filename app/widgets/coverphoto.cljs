(ns widgets.coverphoto)



(defn coverphoto
  "A general cover photo widget"
  [img text]
  [:div {:style {:position "relative"}}
   [:img {:style {:width "100%"
                  :height "240px"}
          :src img}]
   [:h2 {:style {:position "absolute"
                 :left 20
                 :bottom 15}}
    text]])
