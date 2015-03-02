(ns components.new-post-box
  (:require [reagent.core :as r]
            [widgets.button :refer (button)]
            [widgets.textarea :refer (textarea)]
            [actions :refer (new-post)]))



(defn new-post-box
  "A box for creating a post"
  [timeline-id parent-id]
  (let [body (r/atom "")]
    (fn [_ _]
      [:div
       [textarea body]
       [button "Send" #(new-post {:source      ::new-post-box
                                  :timeline-id timeline-id
                                  :parent-id   parent-id
                                  :body        @body})]])))
