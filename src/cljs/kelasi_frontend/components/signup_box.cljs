(ns kelasi-frontend.components.signup-box
  (:require [om-tools.core :as omtool :include-macros true]
            [om-tools.dom  :as dom    :include-macros true]
            [om.core       :as om     :include-macros true]
            [kelasi-frontend.components.find-friends-box
             :refer (find-friends-box)]
            [kelasi-frontend.components.found-friends-box
             :refer (found-friends-box)]
            [kelasi-frontend.components.signup-final-box
             :refer (signup-final-box)]
            [kelasi-frontend.components.signup-progress-breadcrumb
             :refer (signup-progress-breadcrumb)]
            [kelasi-frontend.actions :refer (search-introducer)]))



(omtool/defcomponentk signup-box
  "First page's signup box"
  [[:data friends] owner state]
  (init-state
   [_]
   {:stage 1
    :introducer nil})
  (render
   [_]
   (dom/div
    (condp = (:stage @state)
      1 (om/build find-friends-box {:on-search
                                    (fn [firstname lastname university]
                                      (search-introducer :source ::signup-box
                                                         :firstname firstname
                                                         :lastname lastname
                                                         :university university)
                                      (swap! state assoc :stage 2))})
      2 (om/build found-friends-box {:friends friends
                                     :on-select (fn [introducer]
                                                  (swap! state
                                                         assoc
                                                         :introducer introducer
                                                         :stage 3))})
      3 (om/build signup-final-box {:introducer (atom (:introducer @state))}))

    (om/build signup-progress-breadcrumb {:stage (:stage @state)
                                          :on-click #(swap! state
                                                            assoc :stage
                                                            %)}))))
