(ns kelasi-frontend.components.profile-about-box
  (:require [om-tools.core :as omtool :include-macros true]
            [om-tools.dom  :as dom    :include-macros true]))



(omtool/defcomponentk profile-about-box
  "A box with basic information regarding user"
  [[:data firstname lastname email] owner state]
  (render
    [_]
    (dom/div
      (dom/div "First name:"
               (dom/div firstname))
      (dom/div "Last name:"
               (dom/div lastname))
      (dom/div "Email:"
               (dom/div email)))))
