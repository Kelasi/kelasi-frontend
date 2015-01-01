(ns kelasi-frontend.components.search-page
  (:require [om-tools.core :as omtool :include-macros true]
            [om-tools.dom  :as dom    :include-macros true]
            [om.core       :as om     :include-macros true]
            [reagent.core :as r]
            [kelasi-frontend.components.navbar :refer (navbar)]
            [kelasi-frontend.components.timeline-list-box
             :refer (timeline-list-box)]
            [kelasi-frontend.components.user-list-box
             :refer (user-list-box)]
            [kelasi-frontend.actions
             :refer (show-timeline show-user-profile)]))



(omtool/defcomponentk search-page
  "Search results page"
  [[:data
    [:search people timelines]
    [:users all-users current-user]
    all-timelines]]
  (render
    [_]
    (dom/div
      (r/as-element [navbar current-user])

      (dom/h2 "Found timelines")
      (om/build timeline-list-box {:ids timelines
                                   :timelines all-timelines
                                   :people all-users
                                   :on-select #(show-timeline {:source ::search-page
                                                               :timeline-id (:id @%)})})

      (dom/h2 "Found users")
      (om/build user-list-box {:ids people
                               :people all-users
                               :selected nil
                               :on-select #(show-user-profile {:source ::search-page
                                                               :user-id (:id @%)})}))))
