(ns components.found-friends-box-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [components.found-friends-box :refer (found-friends-box)]
            [state :refer (app-state)]
            [reagent.core :as r]
            [mocks.user :refer (user1 user2 user3)]
            [devcards.core :as dc :include-macros true]))



(def users [user1 user2 user3])
(def elem [found-friends-box
           (mapv :id users) ;ids
           (zipmap (mapv :id users) users) ;people
           (fn [s] (pr "Selected:" s))]) ;on-select

(defcard found-friends-box-component
  (dc/react-card (r/as-element elem)))
