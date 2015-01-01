(ns kelasi-frontend.components.profile-page
  (:require [om-tools.core :as omtool :include-macros true]
            [om-tools.dom  :as dom    :include-macros true]
            [om.core       :as om     :include-macros true]
            [reagent.core :as r]
            [kelasi-frontend.components.navbar :refer (navbar)]
            [kelasi-frontend.components.coverphoto-box
             :refer (coverphoto-box)]
            [kelasi-frontend.components.profile-about-box
             :refer (profile-about-box)]
            [kelasi-frontend.components.timeline-list-box
             :refer (timeline-list-box)]
            [kelasi-frontend.actions
             :refer (show-timeline)]))



(omtool/defcomponentk profile-page
  "The profile page of a user"
  [[:data user users all-timelines]]
  (render
    [_]
    (dom/div
      (om/build navbar {:current-user (:current-user users)})

      (r/as-element (coverphoto-box (:img user) (:profile-name user)))

      (dom/div {:style {:width "33%"
                        :float "left"}}
               (om/build profile-about-box {:firstname (:profile-name user)
                                            :lastname (:full-name user)
                                            :email (:email user)}))

      (dom/div {:style {:width "33%"
                        :float "left"}}
               (dom/h2 "User's timelines:")
               (om/build timeline-list-box {:ids (:timelines user)
                                            :timelines all-timelines
                                            :people (:all-users users)
                                            :on-select #(show-timeline {:source ::profile-page
                                                                        :timeline-id (:id @%)})}))

      (dom/div {:style {:width "33%"
                        :float "left"}}
               (dom/h2 "Followed timelines:")
               (om/build timeline-list-box {:ids (:followed-timelines user)
                                            :timelines all-timelines
                                            :people (:all-users users)
                                            :on-select #(show-timeline {:source ::profile-page
                                                                        :timeline-id (:id @%)})})))))
