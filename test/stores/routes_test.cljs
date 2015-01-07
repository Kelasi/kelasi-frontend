(ns stores.routes-test
  (:require-macros [mocha-tester.core :refer (describe it before after)]
                   [chaiify.core :refer (expect)])
  (:require [stores.routes :as routes]
            [actions :as action]
            [state :refer (app-state)]
            [cljs.core.async :refer (chan tap untap take!)]
            [mocks.location :as loc]))



(def user {:id "123"
           :profile-name "johnGalt"})

(def done-ch (chan))

(describe "login action"
  (before [done]
    (loc/stub)
    (tap routes/done done-ch)

    (action/load-user {:source ::login-test
                       :user   user})
    (take! done-ch identity)

    (action/login {:source  ::login-test
                   :user-id (:id user)})
    (take! done-ch (fn [_] (done))))

  (after
    (untap routes/done done-ch)
    (loc/unstub))

  (it "should go to /profile/:profile_name"
    (expect (loc/went-to? "/profile/johnGalt") :to-be-true)))

(describe "show-timeline action"
  (before [done]
    (loc/stub)
    (tap routes/done done-ch)

    (action/show-timeline {:source ::show-timeline-test
                           :timeline-id "123"})

    (take! done-ch (fn [_] (done))))

  (after
    (untap routes/done done-ch)
    (loc/unstub))

  (it "should go to /timeline/:timeline_id"
    (expect (loc/went-to? "/timeline/123") :to-be-true)))
