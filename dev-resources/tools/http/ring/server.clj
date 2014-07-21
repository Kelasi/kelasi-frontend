(ns ring.server
  (:require [cemerick.austin.repls :refer (browser-connected-repl-js)]
            [net.cgrand.enlive-html :as enlive]
            [compojure.route :refer  (resources)]
            [compojure.core :refer (GET defroutes)]
            [ring.adapter.jetty :as jetty]
            [mocha-tester.core :as mocha]
            [clojure.java.io :as io]))

(enlive/deftemplate page
  (io/resource "public/index.html")
  []
  [:body] (enlive/append
            (enlive/html [:script (browser-connected-repl-js)])))

(enlive/deftemplate test-page
  (io/resource "public/index.html")
  []
  [:body [:script (enlive/attr= :src "/js/kelasi_frontend.js")]]
    (enlive/do-> (enlive/remove-attr :src)
                 (enlive/set-attr :src "/js_test/kelasi_frontend.js")))

(defroutes site
  (resources "/")
  (GET "/mocha-test" req (test-page))
  (GET "/*" req (page)))

(defn run
  "Run the ring server. It defines the server symbol with defonce."
  []
  (defonce server
    (jetty/run-jetty (mocha/wrap #'site) {:port 3000 :join? false}))
  server)
