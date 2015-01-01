(ns ring.server
  (:require [weasel.repl.websocket :as weasel]
            [cemerick.piggieback :as piggieback]
            [net.cgrand.enlive-html :as enlive]
            [compojure.route :refer  (resources not-found)]
            [compojure.core :refer (GET defroutes)]
            [frodo.web :refer (App)]
            [mocha-tester.core :as mocha]
            [chaiify.core :as chai]
            [clojure.java.io :as io]))



(enlive/deftemplate test-page
  (io/resource "public/index.html")
  []
  [:body [:script (enlive/attr= :src "/js/kelasi_frontend.js")]]
    (enlive/substitute (enlive/html [:script {:src "/js_test/goog/base.js"}]
                                    [:script {:src "/vendor/sinon-1.10.3.js"}]
                                    [:script {:src "/js_test/kelasi_frontend.js"}]
                                    [:script "goog.require('kelasi_frontend.all_tests');"])))

(defroutes site
  (resources "/")
  (resources "/vendor" {:root ""})
  (GET "/mocha-test" req (test-page))
  (not-found "<p>404 Not found!</p>"))


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
