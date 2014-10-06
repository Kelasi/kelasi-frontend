(ns kelasi-frontend.components.post-box
  (:require [om-tools.core :as omtool :include-macros true]
            [om-tools.dom  :as dom    :include-macros true]
            [om.core       :as om     :include-macros true]
            [kelasi-frontend.components.post-list :refer (post-list)]))



(omtool/defcomponentk post-box
  "A box for showing a post and its replies"
  [[:data post all-users] owner state]
  (render
    [_]
    (dom/div
      (let [user (all-users (:user-id post))]
        (dom/div
          (dom/img {:src (:img user)})
          (:full-name user)))
      (dom/div (:body post))
      (om/build post-list {:posts (:replies post)
                           :all-users all-users}))))
