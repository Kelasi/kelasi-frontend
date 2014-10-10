(ns kelasi-frontend.components.post-box
  (:require [om-tools.core :as omtool :include-macros true]
            [om-tools.dom  :as dom    :include-macros true]
            [om.core       :as om     :include-macros true]))



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
      (for [reply (:replies post)]
        (om/build post-box {:post reply
                            :all-users all-users})))))
