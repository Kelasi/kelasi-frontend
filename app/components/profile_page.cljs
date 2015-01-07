(ns kelasi-frontend.components.profile-page
  (:require [kelasi-frontend.components.navbar :refer (navbar)]
            [kelasi-frontend.components.coverphoto-box
             :refer (coverphoto-box)]
            [kelasi-frontend.components.profile-about-box
             :refer (profile-about-box)]
            [kelasi-frontend.components.timeline-list-box
             :refer (timeline-list-box)]
            [kelasi-frontend.actions
             :refer (show-timeline)]))



(defn profile-page
  "The profile page of a user"
  [user users all-timelines]
  [:div
   [navbar (:current-user users)]

   [coverphoto-box (:img user) (:profile-name user)]

   [:div {:style {:width "33%"
                  :float "left"}}
    [profile-about-box (:profile-name user) (:full-name user) (:email user)]]

   [:div {:style {:width "33%"
                  :float "left"}}
    [:h2 "User's timelines:"]
    [timeline-list-box (:timelines user)
     all-timelines (:all-users users)
     #(show-timeline {:source ::profile-page
                      :timeline-id (:id @%)})]]

   [:div {:style {:width "33%"
                  :float "left"}}
    [:h2 "Followed timelines:"]
    [timeline-list-box (:followed-timelines user)
     all-timelines (:all-users users)
     #(show-timeline {:source ::profile-page
                      :timeline-id (:id @%)})]]])
