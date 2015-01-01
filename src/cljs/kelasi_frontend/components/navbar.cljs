(ns kelasi-frontend.components.navbar
  (:require [reagent.core :as r]
            [kelasi-frontend.actions
             :refer (search-all show-self-profile)]))



(defn navbar
  "The main navbar at the top of all pages"
  [current-user]
  (let [search (r/atom "")]
    (fn
      [_]
      [:div {:style {:width "100%"
                     :backgroundColor "#cc9"}}

       [:span "Kelasi"]

       [:input {:type "text"
                :value @search
                :on-change #(reset! search (.-target.value %))
                :on-key-press #(search-all {:source ::navbar
                                            :q      @search})}]

       (when current-user
         [:a {:href ""
              :style {:float "right"}
              :on-click (fn [ev]
                          (.preventDefault ev)
                          (show-self-profile {:source ::navbar}))}
          (:full-name current-user)])])))
