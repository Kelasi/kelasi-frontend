(ns kelasi-frontend.routes-test
  (:require-macros [cemerick.cljs.test :refer (deftest testing is done)])
  (:require [cemerick.cljs.test :as t]
            [kelasi-frontend.routes :as routes]))


(deftest home-path
  (testing "We should have it, and pointing to '/'"
    (is (= "/" (routes/home-path)))))


(deftest sub-path
  (testing "It should be available"
    (is (= "/test" (routes/sub-path {:path "test"})))))

