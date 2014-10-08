(ns kelasi-frontend.stores.posts-test
  (:require-macros [mocha-tester.core :refer (describe it before after)]
                   [chaiify.core :refer (expect)]
                   [cljs.core.async.macros :refer (go)])
  (:require [kelasi-frontend.stores.posts :as posts]
            [kelasi-frontend.actions :as action]
            [kelasi-frontend.backend.posts   :refer (create)]
            [kelasi-frontend.state :refer (app-state)]
            [cljs.core.async :refer (chan tap untap take!)]))



(def done-ch (chan))

(describe "new-post action"
  (before [done]
    (.stub js/sinon kelasi-frontend.backend.posts "create")
    (tap posts/done done-ch)
    (action/new-post :source ::new-post-test
                     :timeline-id "1"
                     :parent-id "0"
                     :body "test")
    (take! done-ch #(done)))

  (after
    (.restore create)
    (untap posts/done done-ch))

  (it "should call backend.posts/create with right params"
    (expect (.-calledOnce create) :to-be-true)
    (expect (.calledWithExactly create "1" "0" "test") :to-be-true)))
