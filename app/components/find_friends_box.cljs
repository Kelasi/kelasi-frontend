(ns components.find-friends-box
  (:require [reagent.core :as r]
            [widgets.labeled-input :refer (labeled-input)]))



(defn find-friends-box
  "First step of registration."
  [on-search]
  (let [firstname  (r/atom "")
        lastname   (r/atom "")
        university (r/atom "")]
    (fn [_]
      [:div
       [:p "Enter your friend's data:"]

       [labeled-input "First name:" firstname]

       [labeled-input "Last name:" lastname]

       [labeled-input "University name:" university]

       [:button {:type "button"
                 :on-click #(on-search @firstname @lastname @university)}
        "Search"]])))
