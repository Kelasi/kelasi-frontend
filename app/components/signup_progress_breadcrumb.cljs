(ns kelasi-frontend.components.signup-progress-breadcrumb)



(defn signup-progress-breadcrumb
  "A breadcrumb to show the progress in signup process"
  [stage on-click]
  [:div
   [:span {:style {:backgroundColor (if (>= stage 1) "#333" "#fff")}}
    [:a {:href ""
         :on-click (fn [ev] (.preventDefault ev) (on-click 1))}
     "Stage 1"]]

   [:span {:style {:backgroundColor (if (>= stage 2) "#333" "#fff")}}
    [:a {:href ""
         :on-click (fn [ev] (.preventDefault ev) (on-click 2))}
     "Stage 2"]]

   [:span {:style {:backgroundColor (if (>= stage 3) "#333" "#fff")}}
    [:a {:href ""
         :on-click (fn [ev] (.preventDefault ev) (on-click 3))}
     "Stage 3"]]])
