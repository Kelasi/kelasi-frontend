(ns kelasi-frontend.dispatcher-test
  (:require-macros [cljs.core.async.macros :refer (go)])
  (:require [kelasi-frontend.dispatcher :as dis]
            [cljs.core.async :as async :refer (>! <! chan)]
            [cemerick.cljs.test :include-macros true
             :refer (deftest testing is done)]))

(deftest ^:async create-chan
  (let [finish (chan)]

    (testing "should create chans which recieve when calling dispatch"
      (let [disp (dis/create-chan)]
        (dis/dispatch 10)
        (go (is (= 10 (<! disp)))
            (>! finish true))))

    (go (repeatedly 1 #(<! chan))
        (done))))