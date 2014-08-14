{:dev  {:source-paths ["resources/tools/http" "resources/tools/repl"]
        :test-paths ["test/clj" "test/cljs"]
        :clean-targets ["out" :target-path]
        :dependencies [[ring "1.2.2"]
                       [compojure "1.1.7"]
                       [enlive "1.1.5"]]
        :plugins [[com.cemerick/austin "0.1.3"]
                  [com.cemerick/clojurescript.test "0.3.1"]]

        :injections [(require '[ring.server :as http :refer [run]]
                              'cemerick.austin.repls)
                     (defn browser-repl []
                       (cemerick.austin.repls/cljs-repl (reset! cemerick.austin.repls/browser-repl-env
                                                                (cemerick.austin/repl-env))))
                     (defn brepl-env [] (deref cemerick.austin.repls/browser-repl-env))]}

 :production {:cljsbuild
              {:builds [{:id "kelasi-frontend-production"
                         :source-paths ["src/cljs"]
                         :compiler
                         {:output-to "public/js/app.js"
                          :externs ["resources/public/vendor/react/react.js"]
                          :preamble ["react/react.min.js"]
                          :closure-warnings {:externs-validation :off
                                             :non-standard-jsdoc :off}
                          :optimizations :advanced
                          :pretty-print false}}]}}}
