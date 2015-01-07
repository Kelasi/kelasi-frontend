(ns components.post-list-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [components.post-list :refer (post-list)]
            [state :refer (app-state)]
            [reagent.core :as r]
            [mocks.post :refer (post1 post2 post3)]
            [mocks.user :refer (user1)]
            [devcards.core :as dc :include-macros true]))

(defcard global-state
  (dc/edn-card @app-state))

(def mini-state
  {:posts [(assoc post1 :replies [post2 post3])
           post2
           post3]
   :all-users {"2" user1}})

(defcard post-list-component
  (dc/react-card (r/as-element (post-list (:posts mini-state)
                                          (:all-users mini-state)))))
