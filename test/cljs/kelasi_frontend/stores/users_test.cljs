(ns kelasi-frontend.stores.users-test
  (:require-macros [mocha-tester.core :refer (describe it before after)]
                   [chaiify.core :refer (expect)])
  (:require [kelasi-frontend.stores.users :as users]
            [kelasi-frontend.actions :refer (try-login)]
            [kelasi-frontend.backend.session :refer (login)]
            [kelasi-frontend.utilities :as utils]))

(def login-data {:user-name "John" :password "BlahBlah"})

(describe "try-login action"
  (before
    (.stub js/sinon kelasi-frontend.backend.session "login"))

  (after
    (.restore login))

  (it "should call backend.session/login with username and password" [done]
    (try-login :test login-data)

    (utils/after 50
      (fn []
        (expect (.-calledOnce login) :to-be-true)
        (expect (.calledWithExactly login "John" "BlahBlah") :to-be-true)
        (done)))))
