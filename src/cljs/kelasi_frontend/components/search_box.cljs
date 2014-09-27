(ns kelasi-frontend.components.search-box
  (:require [om-tools.core :as omtool :include-macros true]
            [om-tools.dom  :as dom    :include-macros true]
            [kelasi-frontend.actions :refer (search-all)]))



(omtool/defcomponentk search-box
  "First page's search box"
  [data owner state]
  (init-state
    [_]
    {:search ""})
  (render
    [_]
    (dom/div
      (dom/p "Search:"
             (dom/input
               {:type "text"
                :value (:search @state)
                :on-change #(swap! state assoc :search (.. % -target -value))
                :on-key-press #(when (= 13 (.-charCode %))
                                 (search-all :source ::search-box
                                             :q (:search @state)))})))))
