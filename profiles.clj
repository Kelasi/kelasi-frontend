{:dev  {:source-paths ["dev-resources/tools/http" "dev-resources/tools/repl"]
        :test-paths ["test/clj" "test/cljs"]
        :resources-paths ["dev-resources"]
        :clean-targets ["out" :target-path]
        :dependencies [[ring "1.2.2"]
                       [compojure "1.1.7"]
                       [enlive "1.1.5"]]
        :plugins [[com.cemerick/austin "0.1.3"]
                  [com.cemerick/clojurescript.test "0.3.1"]]

        :cljsbuild
        {:builds {:kelasi-frontend
                 {:source-paths ["dev-resources/tools/repl"]
                  :compiler
                  {:optimizations :whitespace
                   :pretty-print true}}}
         :test-commands {"phantomjs"
                         ["phantomjs" :runner
                          "dev-resources/public/vendor/phantomjs-shims.js"
                          "dev-resources/public/js/kelasi_frontend.js"]}}

        :injections [(require '[ring.server :as http :refer [run]]
                              'cemerick.austin.repls)
                     (defn browser-repl []
                       (cemerick.austin.repls/cljs-repl (reset! cemerick.austin.repls/browser-repl-env
                                                                (cemerick.austin/repl-env))))
                     (defn brepl-env [] (deref cemerick.austin.repls/browser-repl-env))]}

 :production {:cljsbuild
              {:builds {:kelasi-frontend
                        {:compiler
                         {:output-to "public/js/app.js"
                          :optimizations :advanced
                          :pretty-print false}}}}}}

