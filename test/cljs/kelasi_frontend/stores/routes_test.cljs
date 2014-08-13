(ns kelasi-frontend.stores.routes-test
  (:require-macros [mocha-tester.core :refer (describe it)]
                   [chaiify.core :refer (expect)])
  (:require [kelasi-frontend.stores.routes :as routes]
            [kelasi-frontend.actions :as action]
            [kelasi-frontend.utilities :as utils]
            [kelasi-frontend.state :refer (app-state)]))



(def user {:id "123"
           :profile-name "johnGalt"})

(describe "login action"
  (it "should put profile_name into routes/current" [done]
    (action/load-user :source ::login-test
                      :user   user)
    (action/login :source  ::login-test
                  :user-id (:id user))

    (utils/after 30
      (fn []
        (expect (get-in @app-state [:routes :current])
                :to-equal "/profile/johnGalt")
        (done)))))
