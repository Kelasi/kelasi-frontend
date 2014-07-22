(ns kelasi-frontend.dispatcher-test
  (:require-macros [cljs.core.async.macros :refer (go)]
                   [mocha-tester.core :refer (describe it)]
                   [chaiify.core :refer (expect)])
  (:require [kelasi-frontend.dispatcher :as dis]
            [cljs.core.async :refer (>! <! chan)]))

(describe "create-chan"
  (it "should create chans which recieve when calling dispatch" [done]
    (let [disp (dis/create-chan)]
      (dis/dispatch 10)
        (go (expect (<! disp) :to-equal 10)
            (done)))))
