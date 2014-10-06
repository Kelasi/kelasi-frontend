(ns kelasi-frontend.components.post-box-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [kelasi-frontend.components.post-box :refer (post-box)]
            [kelasi-frontend.state :refer (app-state)]
            [mocks.post :refer (post1 post2 post3)]
            [mocks.user :refer (user1)]
            [devcards.core :as dc :include-macros true]))

(defcard global-state
  (dc/edn-card @app-state))

(def mini-state
  {:post (assoc post1 :replies [post2 post3])
   :all-users {"2" user1}})

(defcard post-box-component
  (dc/om-root-card post-box mini-state))
