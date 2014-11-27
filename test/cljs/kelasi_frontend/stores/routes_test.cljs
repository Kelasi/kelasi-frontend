(ns kelasi-frontend.stores.routes-test
  (:require-macros [mocha-tester.core :refer (describe it before after)]
                   [chaiify.core :refer (expect)])
  (:require [kelasi-frontend.stores.routes :as routes]
            [kelasi-frontend.actions :as action]
            [kelasi-frontend.state :refer (app-state)]
            [kelasi-frontend.location :as location]
            [cljs.core.async :refer (chan tap untap take!)]
            [mocks.location :as loc]))



(def user {:id "123"
           :profile-name "johnGalt"})

(def done-ch (chan))

(describe "login action"
  (before [done]
    (loc/save)
    (tap routes/done done-ch)

    (action/load-user :source ::login-test
                      :user   user)
    (take! done-ch identity)

    (action/login :source  ::login-test
                  :user-id (:id user))
    (take! done-ch (fn [_] (done))))

  (after
    (untap routes/done done-ch)
    (loc/restore))

  (it "should go to /profile/:profile_name"
    (expect (location/current-route)
            :to-equal "/profile/johnGalt")))

(describe "show-timeline action"
  (before [done]
    (loc/save)
    (tap routes/done done-ch)

    (action/show-timeline :source ::show-timeline-test
                          :timeline-id "123")

    (take! done-ch (fn [_] (done))))

  (after
    (untap routes/done done-ch)
    (loc/restore))

  (it "should go to /timeline/:timeline_id"
    (expect (location/current-route)
            :to-equal "/timeline/123")))
