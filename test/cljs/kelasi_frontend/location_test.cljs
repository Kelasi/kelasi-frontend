(ns kelasi-frontend.location-test
  (:require-macros [mocha-tester.core :refer (describe it before after)]
                   [chaiify.core :refer (expect)])
  (:require [kelasi-frontend.location :as location]
            [mocks.location :as loc]))



(describe "current-route"
  (it "should be the same value as location path"
    (expect (location/current-route)
            :to-equal (.. js/window -location -pathname))))



(describe "change-route"
  (before
    (loc/save)
    (location/change-route "/some-path/test"))

  (after
    (loc/restore))

  (it "should change the location bar of browser"
    (expect (location/current-route) :to-equal  "/some-path/test")))
