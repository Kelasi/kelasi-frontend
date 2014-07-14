(ns kelasi-frontend.utilities-test
  (:require-macros [cljs.core.async.macros :refer (go)])
  (:require [kelasi-frontend.utilities :as u]
            [cljs.core.async :refer (<! >! chan timeout)]
            [cemerick.cljs.test :include-macros true
             :refer (deftest testing is done)]))


(deftest ^:async listen

  (let [finished (chan)]

    (testing "It should properly handle ui events"
      (let [button (.createElement js/document "button")
            clicks (u/listen button "click")]
        (.click button)
        (go (let [c (<! clicks)]
              (is (= (.-target c) button))
              (>! finished true)))))

    (testing "should not preventDefault by default"
      (let [link (.createElement js/document "a")
            click-evt (.createEvent js/document "MouseEvent")
            clicks (u/listen link "click")]
        (aset link "href" "/some-path")
        (.initEvent click-evt "click")
        (.dispatchEvent link click-evt)
        (go (let [e (<! clicks)]
              (is (= false (aget e "defaultPrevented")))
              (>! finished true)))))

    (testing "should be able to preventDefault"
      (let [link (.createElement js/document "a")
            click-evt (.createEvent js/document "MouseEvent")
            clicks (u/listen link "click"
                             :prevent-default true)]
        (aset link "href" "/some-path")
        (.initEvent click-evt "click")
        (.dispatchEvent link click-evt)
        (go (let [e (<! clicks)]
              (is (= true (aget e "defaultPrevented")))
              (>! finished true)))))

    (testing "should be able to transform the event through a fn"
      (let [bt (.createElement js/document "button")
            trans #(.-target %)
            clicks (u/listen bt "click" :transform trans)]
        (.click bt)
        (go (let [e (<! clicks)]
              (is (= e bt))
              (>! finished true)))))

    (go (repeatedly 4 (<! (timeout 1000)))
        (done))))
