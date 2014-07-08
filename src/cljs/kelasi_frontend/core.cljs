(ns kelasi-frontend.core
  (:require [om.core :as om]
            [schema.core :as s :include-macros true]
            [om-tools.core :as ot :include-macros true]
            [om-tools.dom :as dom :include-macros true]))

(enable-console-print!)

(def app-state (atom {:text "Hello World!"}))

(def Text {:text s/Str})

(ot/defcomponentk rtcomp [[:data text] :- Text]
  (render [_]
          (dom/h1 {:id "test"} text)))

(om/root rtcomp app-state
  {:target js/document.body})
