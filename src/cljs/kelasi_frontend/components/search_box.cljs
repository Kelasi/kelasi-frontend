(ns kelasi-frontend.components.search-box
  (:require [kelasi-frontend.actions :refer (search-all)]
            [reagent.core :as r]))



(defn search-box
  "First page's search box"
  []
  (let [query (r/atom "")]
    (fn []
      [:div
       [:p "Search:"
        [:input {:type "text"
                 :value @query
                 :on-change #(reset! query (.-target.value %))
                 :on-key-press #(when (= 13 (.-charCode %))
                                  (search-all {:source ::search-box
                                               :q      @query}))}]]])))
