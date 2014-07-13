(ns kelasi-frontend.app
  (:require [om.core :as om]
            [kelasi-frontend.state :refer (app-state)]
            [kelasi-frontend.components.root :refer (root)]))

(enable-console-print!)

(om/root root app-state
  {:target js/document.body})
