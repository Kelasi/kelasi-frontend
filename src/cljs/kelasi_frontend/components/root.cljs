(ns kelasi-frontend.components.root
  (:require [schema.core :as s :include-macros true]
            [om-tools.core :as ot :include-macros true]
            [om-tools.dom :as dom :include-macros true]))



(ot/defcomponentk root [data :- s/Any]
  (render [_]
          (dom/pre {:id "test"} (.stringify js/JSON (clj->js data) nil 2))))
