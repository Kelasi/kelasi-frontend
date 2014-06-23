(ns kelasi-frontend.core
  (:require [om.core :as om]
            [om-tools.core :as ot :include-macros true]
            [om-tools.dom :as dom :include-macros true]))

(enable-console-print!)

(def app-state (atom {:text "Hello World!"}))

(ot/defcomponentk rtcomp [[:data text]]
  (render [_]
          (dom/h1 text)))

(om/root rtcomp app-state
  {:target (.getElementById js/document "app")})
