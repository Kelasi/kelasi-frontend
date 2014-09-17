(ns kelasi-frontend.stores.search-test
  (:require-macros [mocha-tester.core :refer (describe it before after)]
                   [chaiify.core :refer (expect)]
                   [cljs.core.async.macros :refer (go)])
  (:require [kelasi-frontend.stores.search :as search]
            [kelasi-frontend.actions :as action]
            [kelasi-frontend.backend.search :refer (people)]
            [kelasi-frontend.state :refer (app-state)]
            [cljs.core.async :refer (chan tap untap take!)]))



(def search-data {:firstname  "John"
                  :lastname   "Doe"
                  :university "Taashkand"})

(def done-ch (chan))


(describe "search-introducer action"
  (before [done]
    (.stub js/sinon kelasi-frontend.backend.search "people")

    (tap search/done done-ch)
    (action/search-introducer :source     ::search-introducer-test
                              :firstname  (:firstname  search-data)
                              :lastname   (:lastname   search-data)
                              :university (:university search-data))

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
    (action/load-search-result :source ::load-search-result-test
                                :category :people
                                :result '("2" "3" "4"))
    (take! done-ch (fn [_] (done))))

  (after (untap search/done done-ch))

  (it "should put search results in app-state"
    (expect (get-in @app-state [:search :people])
            :to-eql '("2" "3" "4"))))
