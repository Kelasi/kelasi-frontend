(ns pages.timeline-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [pages.timeline :refer (timeline)]
            [state :refer (app-state)]
            [reagent.core :as r]
            [mocks.user :refer (user1)]
            [mocks.post :refer (post1 post2 post3 post4)]
            [devcards.core :as dc :include-macros true]))



(def elem
  [timeline-page
   {:all-users {(:id user1) user1}
    :current-user user1} ;users
   {:id "1"
    :title "Some timeline"
    :cover-image "some.jpg"} ;timeline
   (list post2 (assoc post1 :replies
                      (list post4 post3)))]) ;posts

(defcard timeline-page
  (dc/react-card (r/as-element elem)))
