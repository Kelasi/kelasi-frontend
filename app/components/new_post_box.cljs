(ns components.new-post-box
  (:require [reagent.core :as r]
            [widgets.button :refer (button)]
            [actions :refer (new-post)]))



(defn new-post-box
  "A box for creating a post"
  [timeline-id parent-id]
  (let [body (r/atom "")]
    (fn [_ _]
      [:div
       [:textarea {:value @body
                   :on-change #(reset! body (.-target.value %))}]
       [button "Send" #(new-post {:source      ::new-post-box
                                  :timeline-id timeline-id
                                  :parent-id   parent-id
                                  :body        @body})]])))
