(defproject kelasi-frontend "0.0.1-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"

  :min-lein-version "2.3.4"

  :jvm-opts  ["-Xmx1g"]

  ;; We need to add src/cljs too, because cljsbuild does not add its
  ;; source-paths to the project source-paths
  :source-paths ["src/clj" "src/cljs"]
  :resources-paths ["dev-resources/public/vendor"]

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2234"]
                 [om "0.6.4"]
                 [prismatic/schema  "0.2.4"]
                 [prismatic/om-tools  "0.2.2"]
                 [secretary  "1.2.0"]]

  :plugins [[lein-cljsbuild "1.0.3"]
            [lein-bower "0.4.0"]]

  :hooks [leiningen.cljsbuild]

  :bower  {:directory  "dev-resources/public/vendor"}
  :bower-dependencies [["react" "~0.10.0"]]

  :cljsbuild
  {:builds {;; This build is only used for including any cljs source
            ;; in the packaged jar when you issue lein jar command and
            ;; any other command that depends on it
            :kelasi-frontend
            {:source-paths ["src/cljs"]
             ;; The :jar true option is not needed to include the CLJS
             ;; sources in the packaged jar. This is because we added
             ;; the CLJS source codebase to the Leiningen
             ;; :source-paths
             ;:jar true
             ;; Compilation Options
             :compiler
             {:output-to "dev-resources/public/js/kelasi_frontend.js"
              :preamble ["react/react.min.js"]
              :externs ["dev-resources/public/vendor/react/react.js"]
              :closure-warnings  {:externs-validation :off
                                  :non-standard-jsdoc :off}
              :optimizations :advanced
              :pretty-print false}}}})
