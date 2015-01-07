(ns components.user-list-box-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [components.user-list-box :refer (user-list-box)]
            [state :refer (app-state)]
            [reagent.core :as r]
            [mocks.user :refer (user1 user2 user3)]
            [devcards.core :as dc :include-macros true]))



(def users [user1 user2 user3])
(def elem [user-list-box
           (mapv :id users) ;ids
           (zipmap (mapv :id users) users) ;people
           user1 ;selected
           (fn [s] (pr "selected" s))]) ;on-select

(defcard user-list-box-component
  (dc/react-card (r/as-element elem)))
