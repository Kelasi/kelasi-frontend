(ns kelasi-frontend.components.new-post-box
  (:require [om-tools.core :as omtool :include-macros true]
            [om-tools.dom  :as dom    :include-macros true]
            [kelasi-frontend.actions :refer (new-post)]))



(omtool/defcomponentk new-post-box
  "A box for creating a post"
  [[:data timeline-id parent-id] owner state]
  (init-state
    [_]
    {:body ""})
  (render
    [_]
    (dom/div
      (dom/textarea {:value (:body @state)
                     :on-change #(swap! state assoc
                                        :body (.. % -target -value))})
      (dom/button {:type "button"
                   :on-click #(new-post {:source ::new-post-box
                                         :timeline-id timeline-id
                                         :parent-id parent-id
                                         :body (:body @state)})}
                  "Send"))))
