(ns ring.server
  (:require [simple-brepl.service :refer (brepl-js)]
            [net.cgrand.enlive-html :as enlive]
            [compojure.route :refer  (resources)]
            [compojure.core :refer (GET defroutes)]
            [ring.adapter.jetty :as jetty]
            [mocha-tester.core :as mocha]
            [chaiify.core :as chai]
            [clojure.java.io :as io]))

(enlive/deftemplate page
  (io/resource "public/index.html")
  []
  [:head] (enlive/append
            (enlive/html [:script (brepl-js)])))

(enlive/deftemplate test-page
  (io/resource "public/index.html")
  []
  [:body [:script (enlive/attr= :src "/js/kelasi_frontend.js")]]
    (enlive/substitute (enlive/html [:script {:src "/js_test/goog/base.js"}]
                                    [:script {:src "/vendor/react/react.js"}]
                                    [:script {:src "/vendor/sinon-1.10.3.js"}]
                                    [:script {:src "/js_test/kelasi_frontend.js"}]
                                    [:script "goog.require('kelasi_frontend.app');
                                              goog.require('kelasi_frontend.all_tests');"])))

(defroutes site
  (resources "/")
  (GET "/mocha-test" req (test-page))
  (GET "/*" req (page)))

(defn run
  "Run the ring server. It defines the server symbol with defonce."
  []
  (defonce server
    (jetty/run-jetty (-> #'site
                         (mocha/wrap)
                         (chai/wrap "/mocha-test"))
                     {:port 3000 :join? false}))
  server)
