(ns stores.errors-test
  (:require-macros [mocha-tester.core :refer (describe it before after)]
                   [chaiify.core :refer (expect)]
                   [cljs.core.async.macros :refer (go)])
  (:require [stores.errors :as errors]
            [actions :as actions]
            [state :refer (app-state)]
            [cljs.core.async :refer (chan tap untap take!)]))



(def done-ch (chan))

(describe "wrong-login action"
  (before [done]
    (tap errors/done done-ch)

    (actions/wrong-login {:source ::wrong-login-test})
    (take! done-ch (fn [_] (done))))

  (after (untap errors/done done-ch))

  (it "should put :wrong-login under :errors/login"
    (expect (get-in @app-state [:errors :login])
            :to-eql :wrong-login)))



(describe "net-error action"
  (before [done]
    (tap errors/done done-ch)

    (actions/net-error {:source ::net-error-test
                        :orig   {:some-test 1}})
    (take! done-ch (fn [_] (done))))

  (after (untap errors/done done-ch))

  (it "should put under :errors/net-error the original request"
          (expect (get-in @app-state [:errors :net-error])
                  :to-eql {:some-test 1})))
