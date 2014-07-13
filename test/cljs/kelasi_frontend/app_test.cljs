(ns kelasi-frontend.app-test
  (:require-macros [cemerick.cljs.test :as m :refer (deftest testing is done)])
  (:require [cemerick.cljs.test :as t]
            [kelasi-frontend.app :as k]))

(defn- after [time-in-ms callback]
  (js/setTimeout callback time-in-ms))

(deftest ^:async rtcomp
  (testing "'Hello World' should be rendered to screan"
    (after
      0
      (fn []
        (let [comp-text (.. js/document (querySelector "#test") -innerText)]
          (is (= "Hello World!" comp-text)))
        (done)))))

