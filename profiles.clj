{:dev  {:source-paths ["resources/tools/http" "resources/tools/repl"]
        :test-paths ["test/clj" "test/cljs"]
        :clean-targets ["out" :target-path]
        :dependencies [[ring "1.2.2"]
                       [compojure "1.1.7"]
                       [enlive "1.1.5"]]}

 :production {:cljsbuild
              {:builds [{:id "production"
                         :source-paths ["app"]
                         :compiler
                         {:output-to "public/js/app.js"
                          ;; :externs ["resources/public/vendor/react/react.js"]
                          :preamble ["react/react.min.js"]
                          :closure-warnings {:externs-validation :off
                                             :non-standard-jsdoc :off}
                          :optimizations :advanced
                          :pretty-print false}}]}}}
