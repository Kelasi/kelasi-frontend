(ns stores.search-test
  (:require-macros [mocha-tester.core :refer (describe it before after)]
                   [chaiify.core :refer (expect)]
                   [cljs.core.async.macros :refer (go)])
  (:require [stores.search :as search]
            [actions :as action]
            [backend.search :refer (people all)]
            [state :refer (app-state)]
            [cljs.core.async :refer (chan tap untap take!)]))



(def search-data {:firstname  "John"
                  :lastname   "Doe"
                  :university "Taashkand"})

(def done-ch (chan))


(describe "search-introducer action"
  (before [done]
    (.stub js/sinon backend.search "people")

    (tap search/done done-ch)
    (action/search-introducer {:source     ::search-introducer-test
                               :firstname  (:firstname  search-data)
                               :lastname   (:lastname   search-data)
                               :university (:university search-data)})

    (take! done-ch (fn [_] (done))))

  (after
    (.restore people)
    (untap search/done done-ch))

  (it "should call backend.search/people with provided data"
    (expect (.-calledOnce people) :to-be-true)
    (expect (.calledWithExactly people "John" "Doe" "Taashkand") :to-be-true)))



(describe "load-search-result action"
  (before [done]
    (tap search/done done-ch)
    (action/load-search-result {:source ::load-search-result-test
                                :category :people
                                :result '("2" "3" "4")})
    (take! done-ch (fn [_] (done))))

  (after (untap search/done done-ch))

  (it "should put search results in app-state"
    (expect (get-in @app-state [:search :people])
            :to-eql '("2" "3" "4"))))



(describe "search-all action"
  (before [done]
    (.stub js/sinon backend.search "all")

    (tap search/done done-ch)
    (action/search-all {:source ::search-all-test
                        :q "testing"})

    (take! done-ch (fn [_] (done))))

  (after
    (.restore all)
    (untap search/done done-ch))

  (it "should call backend.search/all with query string"
    (expect (.-calledOnce all) :to-be-true)
    (expect (.calledWithExactly all "testing") :to-be-true)))
