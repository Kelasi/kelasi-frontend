(ns kelasi-frontend.components.root
  (:require [schema.core :as s :include-macros true]
            [om.core :as om :include-macros true]
            [om-tools.core :as ot :include-macros true]
            [om-tools.dom :as dom :include-macros true]))



(ot/defcomponentk root [data :- s/Any]
  (render
    [_]
    (let [page (get-in data [:routes :current-page])]
      (if (:page page)
        (om/build (:page page) data {:opts {:params (:params page)}})
        (dom/div "Loading...")))))
