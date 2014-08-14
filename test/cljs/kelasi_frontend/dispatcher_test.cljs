(ns kelasi-frontend.dispatcher-test
  (:require-macros [cljs.core.async.macros :refer (go)]
                   [mocha-tester.core :refer (describe it before after)]
                   [chaiify.core :refer (expect)])
  (:require [kelasi-frontend.dispatcher :as dispatch]
            [cljs.core.async :refer (<! chan tap untap)]))

(describe "create-chan"
  (def disp-chan (chan))

  (before
    (tap dispatch/actions disp-chan))

  (after
    (untap dispatch/actions disp-chan))

  (it "should create chans which recieve when calling dispatch" [done]
    (dispatch/dispatch {:test 10})

    (go (expect (:test (<! disp-chan)) :to-equal 10)
        (done))))
