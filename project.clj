(defproject kelasi-frontend "0.0.1-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"

  :min-lein-version "2.3.4"

  :jvm-opts  ["-Xmx1g"]

  :source-paths ["src/clj" "src/cljs"]
  :resources-paths ["dev-resources/public/vendor"]

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2261"]
                 [org.clojure/core.async  "0.1.303.0-886421-alpha"]
                 [om "0.6.4"]
                 [prismatic/schema  "0.2.4"]
                 [prismatic/om-tools  "0.2.2"]
                 [org.clojars.mkhoeini/mocha-tester "0.1.0-SNAPSHOT"]
                 [secretary  "1.2.0"]]

  :plugins [[lein-cljsbuild "1.0.3"]
            [lein-bower "0.4.0"]]

  :hooks [leiningen.cljsbuild]

  :bower  {:directory  "dev-resources/public/vendor"}
  :bower-dependencies [["react" "0.10.0"]
                       ["mocha" "1.20.1"]]

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
              :optimizations :whitespace
              :pretty-print false}}
            }})
