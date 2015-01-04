(ns kelasi-frontend.app
  (:require [reagent.core :as r]
            [kelasi-frontend.state :refer (app-state)]
            [kelasi-frontend.components.root :refer (root)]))

(enable-console-print!)

(r/render [root app-state] (.getElementById js/document "app"))
