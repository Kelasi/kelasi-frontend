(ns kelasi-frontend.dispatcher-test
  (:require-macros [cljs.core.async.macros :refer (go)]
                   [mocha-tester.core :refer (describe it before after)]
                   [chaiify.core :refer (expect)])
  (:require [kelasi-frontend.dispatcher :as dis]
            [cljs.core.async :refer (>! <! chan)]))

(describe "create-chan"
  (def disp-chan (atom nil))

  (before
    (reset! disp-chan (dis/create-chan)))

  (after
    (dis/drop-chan @disp-chan))

  (it "should create chans which recieve when calling dispatch" [done]
    (dis/dispatch 10)

    (go (expect (<! @disp-chan) :to-equal 10)
        (done))))
