(ns components.found-friends-box
  (:require [widgets.list :as wlst]
            [widgets.media :refer (media)]
            [reagent.core :as r]))



(defn found-friends-box
  "Second step of registration."
  [ids people on-select]
  (let [selected (r/atom nil)]
    (fn [_ _ _]
      [:div
       [:p "Select your friend:"]

       (let [ppl (map #(get people %) ids)
             sel (fn [usr]
                   [:div {:style {:backgroundColor (if (= @selected usr)
                                                     "#333" "#fff")}}
                    [media (:img usr) (:full-name usr)
                     #(reset! selected usr)]])]
         [wlst/list ppl sel])

       (when @selected
         [:button {:type "button"
                   :on-click #(on-select @selected)}
          "Select"])])))
