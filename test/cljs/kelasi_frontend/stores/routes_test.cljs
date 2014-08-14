(ns kelasi-frontend.stores.routes-test
  (:require-macros [mocha-tester.core :refer (describe it before after)]
                   [chaiify.core :refer (expect)])
  (:require [kelasi-frontend.stores.routes :as routes]
            [kelasi-frontend.actions :as action]
            [kelasi-frontend.state :refer (app-state)]
            [cljs.core.async :refer (chan tap untap take!)]))



(def user {:id "123"
           :profile-name "johnGalt"})

(def done-ch (chan))

(describe "login action"
  (before [done]
    (tap routes/done done-ch)

    (action/load-user :source ::login-test
                      :user   user)
    (take! done-ch identity)

    (action/login :source  ::login-test
                  :user-id (:id user))
    (take! done-ch (fn [_] (done)))
    )

  (after (untap routes/done done-ch))

  (it "should put profile_name into routes/current"
    (expect (get-in @app-state [:routes :current])
            :to-equal "/profile/johnGalt")))