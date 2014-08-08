(defproject kelasi-frontend "0.0.1-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"

  :min-lein-version "2.3.4"

  :jvm-opts  ["-Xmx1g"]

  :source-paths ["src/clj" "src/cljs"]
  :resources-paths ["dev-resources/public/vendor"]

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2268"]
                 [org.clojure/core.async  "0.1.303.0-886421-alpha"]
                 [om "0.6.4"]
                 [prismatic/schema  "0.2.6"]
                 [prismatic/om-tools  "0.2.2"
                   :exclusions [org.clojure/clojure]]
                 [org.clojars.mkhoeini/mocha-tester "0.1.0-SNAPSHOT"]
                 [org.clojars.mkhoeini/chaiify "0.1.0-SNAPSHOT"]
                 [devcards "0.1.1-SNAPSHOT"]
                 [shoreleave/shoreleave-remote "0.3.0"]
                 [secretary  "1.2.0"]]

  :plugins [[lein-cljsbuild "1.0.3"]
            [lein-bower "0.4.0"]]

  :bower  {:directory  "dev-resources/public/vendor"}
  :bower-dependencies [["react" "0.10.0"]]

  :cljsbuild
  {:builds {:kelasi-frontend
            {:source-paths ["src/cljs"]
             :compiler
             {:output-to "dev-resources/public/js/kelasi_frontend.js"
              :output-dir "dev-resources/public/js"
              :source-map "dev-resources/public/js/kelasi_frontend.js.map"
              :externs ["dev-resources/public/vendor/react/react.js"]
              :preamble ["react/react.min.js"]
              :closure-warnings  {:externs-validation :off
                                  :non-standard-jsdoc :off}}}

            :kelasi-frontend-test
            {:source-paths ["src/cljs" "test/cljs"]
             :compiler
             {:output-to "dev-resources/public/js_test/kelasi_frontend.js"
              :output-dir "dev-resources/public/js_test"
              :source-map "dev-resources/public/js_test/kelasi_frontend.js.map"
              :externs ["dev-resources/public/vendor/react/react.js"]
              :preamble ["react/react.min.js"]
              :closure-warnings  {:externs-validation :off
                                  :non-standard-jsdoc :off}
              :optimizations :none
              :pretty-print true}}

            :kelasi-frontend-devcards
            {:source-paths ["src/cljs" "devcards/cljs"]
             :compiler
             {:output-to "dev-resources/public/devcards/js/kelasi_frontend.js"
              :output-dir "dev-resources/public/devcards/js"
              :source-map "dev-resources/public/devcards/js/kelasi_frontend.js.map"
              :externs ["dev-resources/public/vendor/react/react.js"]
              :preamble ["react/react.min.js"]
              :closure-warnings  {:externs-validation :off
                                  :non-standard-jsdoc :off}
              :optimizations :whitespace
              :pretty-print true}}
            }})
