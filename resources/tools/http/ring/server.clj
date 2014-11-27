(ns ring.server
  (:require [weasel.repl.websocket :as weasel]
            [cemerick.piggieback :as piggieback]
            [net.cgrand.enlive-html :as enlive]
            [compojure.route :refer  (resources)]
            [compojure.core :refer (GET defroutes)]
            [frodo.web :refer (App)]
            [mocha-tester.core :as mocha]
            [chaiify.core :as chai]
            [clojure.java.io :as io]))

(enlive/deftemplate page
  (io/resource "public/index.html")
  [])

(enlive/deftemplate test-page
  (io/resource "public/index.html")
  []
  [:body [:script (enlive/attr= :src "/js/kelasi_frontend.js")]]
    (enlive/substitute (enlive/html [:script {:src "/js_test/goog/base.js"}]
                                    [:script {:src "/vendor/react/react.js"}]
                                    [:script {:src "/vendor/sinon-1.10.3.js"}]
                                    [:script {:src "/js_test/kelasi_frontend.js"}]
                                    [:script "goog.require('kelasi_frontend.all_tests');"])))

(defroutes site
  (resources "/")
  (GET "/mocha-test" req (test-page))
  (GET "/*" req (page)))


(defn start-brepl
  "To start a brepl session in the repl"
  []
  (piggieback/cljs-repl
   :repl-env (weasel/repl-env
              :ip "127.0.0.1"
              :port 9001)))

(def app
  (reify App
    (start! [_]
      {:frodo/handler (-> #'site
                          (mocha/wrap)
                          (chai/wrap "/mocha-test"))})
    (stop! [_ _]
      nil)))
