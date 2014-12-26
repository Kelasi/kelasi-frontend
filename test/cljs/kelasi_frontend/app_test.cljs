(ns kelasi-frontend.app-test
  (:require-macros [mocha-tester.core :refer (describe it before after)]
                   [chaiify.core :refer (expect)])
  (:require [kelasi-frontend.app :as k]
            [kelasi-frontend.state :refer (app-state)]))



#_(describe "index page"
  (def state (atom nil))

  (before
   (reset! state @app-state))

  (after
   (reset! app-state @state))

  (it "should render state to screen" [done]
    (reset! app-state {:test 123})

    (let [cb (fn []
               (let [comp-text (.. js/document (querySelector "#test") -innerHTML)]
                 (expect comp-text :to-equal "{\n  \"test\": 123\n}"))
               (done))]
      (js/setTimeout cb 500))))
