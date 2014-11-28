(ns kelasi-frontend.routes-test
  (:require-macros [mocha-tester.core :refer (describe it)]
                   [chaiify.core :refer (expect)])
  (:require [kelasi-frontend.routes :as routes]
            [kelasi-frontend.components.entrance-page :refer (entrance-page)]
            [kelasi-frontend.components.notfound-page :refer (notfound-page)]
            [secretary.core :as secretary]))



(describe "home-path"
  (it "should point to '/'"
    (expect (routes/home-path) :to-equal "/"))

  (it "should get the entrance page with no params when routing to '/'"
    (expect (secretary/dispatch! "/") :to-eql [entrance-page {}])))



(describe "notfound-path"
  (it "should be available"
    (expect (routes/notfound-path {:path "test"}) :to-equal "/test"))

  (it "should get the notfound page with path when routing to non-existing route"
    (expect (= (secretary/dispatch! "/albala")
               [notfound-page {:path  "albala"}])
            :to-be-true)))
