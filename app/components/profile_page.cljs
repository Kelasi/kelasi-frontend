(ns components.profile-page
  (:require [components.navbar :refer (navbar)]
            [components.coverphoto-box
             :refer (coverphoto-box)]
            [components.profile-about-box
             :refer (profile-about-box)]
            [components.timeline-list-box
             :refer (timeline-list-box)]
            [actions
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
