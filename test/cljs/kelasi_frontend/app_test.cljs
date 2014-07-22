(ns kelasi-frontend.app-test
  (:require-macros [mocha-tester.core :refer (describe it)]
                   [chaiify.core :refer (expect)])
  (:require [kelasi-frontend.app :as k]))



(defn- after [time-in-ms callback]
  (js/setTimeout callback time-in-ms))


(describe "index page"
  (it "'{}' should be rendered to screan" [done]
    (after 0
      (fn []
        (let [comp-text (.. js/document (querySelector "#test") -innerHTML)]
          (expect comp-text :to-equal "{}"))
        (done)))))
