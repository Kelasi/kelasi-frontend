(ns kelasi-frontend.components.coverphoto-box
  (:require [om-tools.core :as omtool :include-macros true]
            [om-tools.dom  :as dom    :include-macros true]))



(omtool/defcomponentk coverphoto-box
  "A cover photo component"
  [[:data img text] owner state]
  (render
    [_]
    (dom/div
      (dom/img {:style {:width "100%"
                        :height "240px"}
                :src img})
      (dom/h2 {:style {:margin "-50px 0 0 20px"}} text))))
