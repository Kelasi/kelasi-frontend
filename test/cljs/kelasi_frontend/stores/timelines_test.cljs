(ns kelasi-frontend.stores.timelines-test
  (:require-macros [mocha-tester.core :refer (describe it before after)]
                   [chaiify.core :refer (expect)]
                   [cljs.core.async.macros :refer (go)])
  (:require [kelasi-frontend.stores.timelines :as timelines]
            [kelasi-frontend.actions :as action]
            [kelasi-frontend.backend.timelines :refer (get-one)]
            [kelasi-frontend.state :refer (app-state)]
            [cljs.core.async :refer (chan tap untap <!)]))



(def timeline-data {:id 123})

(def ch (chan))

(describe "show-timeline action"
  (before
    (.stub js/sinon kelasi-frontend.backend.timelines "get_one")
    (tap timelines/done ch))

  (after
    (.restore get-one)
    (untap timelines/done ch))

  (it "should not call backend.timeline/get-one when the timeline is already loaded" [done]
    (go
      (action/load-timeline :source ::show-timeline-test
                            :timeline timeline-data)

      (<! ch)

      (action/show-timeline :source ::show-timeline-test
                             :timeline-id (:id timeline-data))
      (<! ch)

      (expect (.-called get-one) :to-be-false)

      (done)))

  (it "should call backend.timeline/get-one when the timeline is not loaded" [done]
    (go
      (swap! app-state assoc-in [:timelines :all-timelines (:id timeline-data)] nil)

      (action/show-timeline :source ::show-timeline-test
                             :timeline-id (:id timeline-data))
      (<! ch)

      (expect (.-calledOnce get-one) :to-be-true)

      (done))))



(describe "load-timeline action"
  (it "should put the timeline under timelines/all-timelines" [done]
    (go
      (tap timelines/done ch)

      (action/load-timeline :source ::load-timeline-test
                            :timeline timeline-data)

      (<! ch)

      (expect (get-in @app-state [:timelines :all-timelines (:id timeline-data)]) :to-equal timeline-data)

      (untap timelines/done ch)
      (done))))
