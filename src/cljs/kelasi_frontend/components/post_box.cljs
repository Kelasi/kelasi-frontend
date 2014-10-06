(ns kelasi-frontend.components.post-box
  (:require [om-tools.core :as omtool :include-macros true]
            [om-tools.dom  :as dom    :include-macros true]
            [om.core       :as om     :include-macros true]
            [kelasi-frontend.components.post-list :refer (post-list)]))



(omtool/defcomponentk post-box
  "A box for showing a post and its replies"
  [[:data post] owner state]
  (render
    [_]
    (dom/div
      (dom/div (:body post))
      (om/build post-list {:posts (:replies post)}))))
