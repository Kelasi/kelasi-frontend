(ns kelasi-frontend.stores.errors-test
  (:require-macros [mocha-tester.core :refer (describe it)]
                   [chaiify.core :refer (expect)]
                   [cljs.core.async.macros :refer (go)])
  (:require [kelasi-frontend.stores.errors :as errors]
            [kelasi-frontend.actions :as actions]
            [kelasi-frontend.state :refer (app-state)]
            [cljs.core.async :refer (chan tap untap <!)]))



(describe "wrong-login action"
  (it "should put :wrong-login under :errors/login" [done]
    (go (let [ch (chan)]
          (tap errors/done ch)

          (actions/wrong-login :source ::wrong-login-test)
          (<! ch)

          (expect (get-in @app-state [:errors :login])
                  :to-eql :wrong-login)

          (untap errors/done ch)
          (done)))))
