(ns kelasi-frontend.components.found-friends-box
  (:require [kelasi-frontend.components.user-list-box :refer (user-list-box)]
            [reagent.core :as r]))



(defn found-friends-box
  "Second step of registration."
  [ids people on-select]
  (let [selected (r/atom nil)]
    (fn [_ _ _]
      [:div
       [:p "Select your friend:"]

       [user-list-box ids people @selected #(reset! selected %)]

       (when @selected
         [:button {:type "button"
                   :on-click #(on-select @selected)}
          "Select"])])))
