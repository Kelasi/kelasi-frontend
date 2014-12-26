(defproject kelasi-frontend "0.0.1-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"

  :min-lein-version "2.3.4"

  :jvm-opts  ["-Xmx1g"]

  :source-paths ["src/clj" "src/cljs"]
  :resources-paths ["resources"]

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2371"]
                 [org.clojure/data.json "0.2.5"]
                 [com.cemerick/piggieback "0.1.3"]
                 [weasel "0.4.2"]
                 [org.clojure/core.async  "0.1.346.0-17112a-alpha"]
                 [om "0.7.3"]
                 [prismatic/schema  "0.3.3"]
                 [prismatic/om-tools  "0.3.2"
                   :exclusions [org.clojure/clojure
                                org.clojure/clojurescript]]
                 [org.clojars.mkhoeini/mocha-tester "0.1.0-SNAPSHOT"]
                 [org.clojars.mkhoeini/chaiify "0.1.0-SNAPSHOT"]
                 [devcards "0.1.2-SNAPSHOT"
                   :exclusions [org.clojure/clojurescript]]
                 [figwheel "0.1.4-SNAPSHOT"]
                 [org.clojars.mkhoeini/router "0.1.0-SNAPSHOT"]]

  :plugins [[lein-cljsbuild "1.0.3"]
            [jarohen/lein-frodo "0.4.1"]
            [lein-figwheel "0.1.4-SNAPSHOT"]
            [lein-bower "0.4.0"]]

  :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}

  :frodo/config-resource "config/nomad.edn"

  :bower  {:directory  "resources/public/vendor"}
  :bower-dependencies [["react" "0.11.1"]]

  :cljsbuild
  {:builds [{:id "kelasi-frontend"
             :source-paths ["src/cljs" "resources/tools/repl"]
             :compiler
             {:output-to "resources/public/js/kelasi_frontend.js"
              :output-dir "resources/public/js"
              :source-map "resources/public/js/kelasi_frontend.js.map"
              :externs ["resources/public/vendor/react/react.js"]
              :preamble ["react/react.min.js"]
              :closure-warnings {:externs-validation :off
                                 :non-standard-jsdoc :off}
              :optimizations :whitespace
              :pretty-print true}}

            {:id "mocha-tests"
             :source-paths ["src/cljs" "test/cljs"]
             :compiler
             {:output-to "resources/public/js_test/kelasi_frontend.js"
              :output-dir "resources/public/js_test"
              :source-map "resources/public/js_test/kelasi_frontend.js.map"
              :externs ["resources/public/vendor/react/react.js"]
              :preamble ["react/react.min.js"]
              :closure-warnings {:externs-validation :off
                                 :non-standard-jsdoc :off}
              :optimizations :none
              :pretty-print true}}

            {:id "devcards"
             :source-paths ["src/cljs" "devcards/cljs" "test/cljs"]
             :compiler
             {:output-to "resources/public/devcards/js/kelasi_frontend.js"
              :output-dir "resources/public/devcards/js"
              :source-map "resources/public/devcards/js/kelasi_frontend.js.map"
              :externs ["resources/public/vendor/react/react.js"]
              :preamble ["react/react.min.js"]
              :closure-warnings {:externs-validation :off
                                 :non-standard-jsdoc :off}
              :optimizations :none
              :pretty-print true}}]})
