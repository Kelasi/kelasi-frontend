(ns kelasi-frontend.utilities-test
  (:require-macros [cljs.core.async.macros :refer (go)]
                   [mocha-tester.core :refer (describe it)]
                   [chaiify.core :refer (expect)])
  (:require [kelasi-frontend.utilities :as u]
            [cljs.core.async :refer (<! >! chan timeout)]))


(describe "listen"

  (it "should properly handle ui events" [done]
    (let [button (.createElement js/document "button")
          clicks (u/listen button "click")]
      (.click button)
      (go (let [c (<! clicks)]
            (expect (.-target c) :to-equal button)
            (done)))))

  (it "should not preventDefault by default" [done]
    (let [link (.createElement js/document "a")
          click-evt (.createEvent js/document "MouseEvent")
          clicks (u/listen link "click")]
      #_(aset link "href" "#")
      (.initEvent click-evt "click" true true)
      (.dispatchEvent link click-evt)
      (go (let [e (<! clicks)]
            (expect (.-defaultPrevented e) :to-be-false)
            (done)))))

  (it "should be able to preventDefault" [done]
    (let [link (.createElement js/document "a")
          click-evt (.createEvent js/document "MouseEvent")
          clicks (u/listen link "click"
                           :prevent-default true)]
      (aset link "href" "#")
      (.initEvent click-evt "click" true true)
      (.dispatchEvent link click-evt)
      (go (let [e (<! clicks)]
            (expect (.-defaultPrevented e) :to-be-true)
            (done)))))

  (it "should be able to transform the event through a fn" [done]
    (let [bt (.createElement js/document "button")
          trans #(.-target %)
          clicks (u/listen bt "click" :transform trans)]
      (.click bt)
      (go (let [e (<! clicks)]
            (expect e :to-equal bt)
            (done))))))
