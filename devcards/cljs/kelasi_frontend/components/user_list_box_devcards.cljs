(ns kelasi-frontend.components.user-list-box-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [kelasi-frontend.components.user-list-box :refer (user-list-box)]
            [kelasi-frontend.state :refer (app-state)]
            [reagent.core :as r]
            [mocks.user :refer (user1 user2 user3)]
            [devcards.core :as dc :include-macros true]))



(def users [user1 user2 user3])
(def elem [user-list-box
           (mapv :id users) ;ids
           (zipmap (mapv :id users) users) ;people
           nil ;selected
           (fn [s] (swap! state assoc :selected s))]) ;on-select

(defcard user-list-box-component
  (dc/react-card (r/as-element elem)))
