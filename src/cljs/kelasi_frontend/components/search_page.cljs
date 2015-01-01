(ns kelasi-frontend.components.search-page
  (:require [kelasi-frontend.components.navbar :refer (navbar)]
            [kelasi-frontend.components.timeline-list-box
             :refer (timeline-list-box)]
            [kelasi-frontend.components.user-list-box
             :refer (user-list-box)]
            [kelasi-frontend.actions
             :refer (show-timeline show-user-profile)]))



(defn search-page
  "Search results page"
  [search users all-timelines]
  (let [people (:people search)
        timelines (:timelines search)
        all-users (:all-users users)
        current-user (:current-user users)]
    [:div
     [navbar current-user]

     [:h2 "Found timelines"]
     [timeline-list-box timelines
      all-timelines all-users
      #(show-timeline {:source ::search-page
                       :timeline-id (:id @%)})]

     [:h2 "Found users"]
     [user-list-box people all-users nil
      #(show-user-profile {:source ::search-page
                           :user-id (:id @%)})]]))
