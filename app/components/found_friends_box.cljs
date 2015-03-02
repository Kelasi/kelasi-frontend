(ns components.found-friends-box
  (:require [widgets.list :as wlst]
            [widgets.media :refer (media)]
            [widgets.button :refer (button)]
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
         [button "Select" #(on-select @selected)])])))
