(ns kelasi-frontend.components.timeline-page-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [kelasi-frontend.components.timeline-page :refer (timeline-page)]
            [kelasi-frontend.state :refer (app-state)]
            [mocks.user :refer (user1)]
            [mocks.post :refer (post1 post2 post3 post4)]
            [devcards.core :as dc :include-macros true]))

(defcard global-state
  (dc/edn-card @app-state))

(def mini-state
  {:users {:all-users {(:id user1) user1}
           :current-user user1}
   :timeline {:id "1"
              :title "Some timeline"
              :cover-image "some.jpg"}
   :posts (list post2 (assoc post1 :replies
                             (list post4 post3)))
   })

(defcard timeline-page-component
  (dc/om-root-card timeline-page mini-state))
