(ns components.find-friends-box
  (:require [reagent.core :as r]))



(defn find-friends-box
  "First step of registration."
  [on-search]
  (let [firstname  (r/atom "")
        lastname   (r/atom "")
        university (r/atom "")]
    (fn [_]
      [:div
       [:p "Enter your friend's data:"]

       [:p "First name:"
        [:input {:type "text"
                 :value @firstname
                 :on-change #(reset! firstname (.-target.value %))}]]

       [:p "Last name:"
        [:input {:type "text"
                 :value @lastname
                 :on-change #(reset! lastname (.-target.value %))}]]

       [:p "University name:"
        [:input {:type "text"
                 :value @university
                 :on-change #(reset! university (.-target.value %))}]]

       [:button {:type "button"
                 :on-click #(on-search @firstname @lastname @university)}
        "Search"]])))
