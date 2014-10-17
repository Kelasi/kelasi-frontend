(ns kelasi-frontend.components.search-page
  (:require [om-tools.core :as omtool :include-macros true]
            [om-tools.dom  :as dom    :include-macros true]
            [om.core       :as om     :include-macros true]
            [kelasi-frontend.components.navbar :refer (navbar)]
            [kelasi-frontend.components.timeline-list-box
             :refer (timeline-list-box)]
            [kelasi-frontend.components.user-list-box
             :refer (user-list-box)]))



(omtool/defcomponentk search-page
  "Search results page"
  [[:data
    [:search people timelines]
    [:users all-users current-user]
    all-timelines]]
  (render
    [_]
    (dom/div
      (om/build navbar {:current-user current-user})

      (dom/h2 "Found timelines")
      (om/build timeline-list-box {:ids timelines
                                   :timelines all-timelines
                                   :people all-users
                                   :on-select #(pr "timeline" %)})

      (dom/h2 "Found users")
      (om/build user-list-box {:ids people
                               :people all-users
                               :selected nil
                               :on-select #(pr "user" @%)}))))
