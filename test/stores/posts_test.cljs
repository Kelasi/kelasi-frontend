(ns stores.posts-test
  (:require-macros [mocha-tester.core :refer (describe it before after)]
                   [chaiify.core :refer (expect)]
                   [cljs.core.async.macros :refer (go)])
  (:require [stores.posts :as posts]
            [actions :as action]
            [backend.posts   :refer (create)]
            [state :refer (app-state)]
            [mocks.post :refer (post1 post2 post3 post4)]
            [cljs.core.async :refer (chan tap untap take!)]))



(def done-ch (chan))

(describe "new-post action"
  (before [done]
    (.stub js/sinon backend.posts "create")
    (tap posts/done done-ch)
    (action/new-post {:source ::new-post-test
                      :timeline-id "1"
                      :parent-id "0"
                      :body "test"})
    (take! done-ch #(done)))

  (after
    (.restore create)
    (untap posts/done done-ch))

  (it "should call backend.posts/create with right params"
    (expect (.-calledOnce create) :to-be-true)
    (expect (.calledWithExactly create "1" "0" "test") :to-be-true)))



(describe "load-post action"
  (before [done]
    (tap posts/done done-ch)
    (action/load-post {:source ::load-post-test
                       :post post1})
    (action/load-post {:source ::load-post-test
                       :post post2})
    (action/load-post {:source ::load-post-test
                       :post post3})
    (action/load-post {:source ::load-post-test
                       :post post4})
    (dotimes [i 3] (take! done-ch identity))
    (take! done-ch #(done)))

  (after (untap posts/done done-ch))

  (it "should put posts in the right order"
    (let [posts (get-in @app-state [:posts "1"])]
      (expect (= posts [post2 (assoc post1 :replies [post4 post3])])
              :to-be-true))))
