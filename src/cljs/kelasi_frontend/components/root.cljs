(ns kelasi-frontend.components.root
  (:require [schema.core :as s :include-macros true]
            [om-tools.core :as ot :include-macros true]
            [om-tools.dom :as dom :include-macros true]))



(ot/defcomponentk root [data :- s/Any]
  (render [_]
          (dom/h1 {:id "test"} (pr-str data))))
