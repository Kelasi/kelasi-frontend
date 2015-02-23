(ns pages.search
  (:require [components.navbar :refer (navbar)]
            [components.timeline-list-box
             :refer (timeline-list-box)]
            [widgets.list :as wlst]
            [widgets.media :refer (media)]
            [actions
             :refer (show-timeline show-user-profile)]))



(defn search
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
      #(show-timeline {:source ::search
                       :timeline-id (:id %)})]

     [:h2 "Found users"]
     (let [ppl (map #(get all-users %) people)
           wfn (fn [usr]
                 [media (:img usr) (:full-name usr)
                  #(show-user-profile {:source ::search
                                       :user-id (:id usr)})])]
       [wlst/list ppl wfn])]))
