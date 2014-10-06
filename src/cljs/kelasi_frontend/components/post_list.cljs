(ns kelasi-frontend.components.post-list
  (:require [om-tools.core :as omtool :include-macros true]
            [om-tools.dom  :as dom    :include-macros true]
            [om.core       :as om     :include-macros true]
            [kelasi-frontend.components.post-box :refer (post-box)]))



(omtool/defcomponentk post-list
  "List of timeline posts"
  [[:data posts all-users]]
  (render
    [_]
    (dom/div
      (for [post posts]
        (om/build post-box {:post post
                            :all-users all-users})))))
