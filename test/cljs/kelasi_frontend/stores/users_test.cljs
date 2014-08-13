(ns kelasi-frontend.stores.users-test
  (:require-macros [mocha-tester.core :refer (describe it before after)]
                   [chaiify.core :refer (expect)]
                   [cljs.core.async.macros :refer (go)])
  (:require [kelasi-frontend.stores.users :as users]
            [kelasi-frontend.actions :as action]
            [kelasi-frontend.backend.session :refer (login)]
            [kelasi-frontend.utilities :as utils]
            [kelasi-frontend.state :refer (app-state)]
            [cljs.core.async :refer (chan tap untap <!)]))



(def login-data {:username "John" :password "BlahBlah"})

(describe "try-login action"
  (before
    (.stub js/sinon kelasi-frontend.backend.session "login"))

  (after
    (.restore login))

  (it "should call backend.session/login with username and password" [done]
    (action/try-login :source ::try-login-test
                      :username (:username login-data)
                      :password (:password login-data))

    (utils/after 30
      (fn []
        (expect (.-calledOnce login) :to-be-true)
        (expect (.calledWithExactly login "John" "BlahBlah") :to-be-true)
        (done)))))



(def user-data {:id "123"})

(describe "load-user action"
  (it "should put the id of a user under users/all-users" [done]
    (action/load-user :source ::load-user-test
                      :user   user-data)

    (utils/after 30
      (fn []
        (expect (get-in @app-state [:users :all-users (:id user-data)]) :to-equal user-data)
        (done)))))



(describe "login action"
  (it "should put the user under users/current-user" [done]
    (action/load-user :source ::login-test
                      :user   user-data)
    (action/login :source  ::login-test
                  :user-id (:id user-data))

    (utils/after 30
      (fn []
        (expect (get-in @app-state [:users :current-user]) :to-equal user-data)
        (done)))))



(describe "wrong-login action"
  (it "should put nil under users/current-user" [done]
    (swap! app-state assoc-in [:users :current-user] :some-value)

    (go (let [ch (chan)]
          (tap users/done ch)
          (action/wrong-login :source ::wrong-login-test)
          (<! ch)
          (expect (get-in @app-state [:users :current-user])
                  :to-not-exist)
          (untap users/done ch)
          (done)))))
