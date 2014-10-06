(ns kelasi-frontend.components.post-list
  (:require [om-tools.core :as omtool :include-macros true]
            [om-tools.dom  :as dom    :include-macros true]))



(omtool/defcomponentk post-list
  "List of timeline posts"
  []
  (render
    [_]
    (dom/div "")))
