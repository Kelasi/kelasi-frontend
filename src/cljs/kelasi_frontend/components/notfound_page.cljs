(ns kelasi-frontend.components.notfound-page
  (:require [om-tools.core :as omtool :include-macros true]
            [om-tools.dom  :as dom    :include-macros true]))



(omtool/defcomponentk notfound-page
  "404 page"
  [opts]
  (render
    [_]
    (dom/div
      "The page you are looking for: "
      (dom/em (get-in opts [:params :path]))
      "Does not exist.")))
