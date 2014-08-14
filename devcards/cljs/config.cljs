(ns config
  (:require [devcards.core :as dc :include-macros true]
            [figwheel.client :as fw :include-macros true]
            [kelasi-frontend.components.root-devcards]
            [kelasi-frontend.components.login-box-devcards]
            ))

(enable-console-print!)

(dc/start-devcard-ui!)

#_(fw/watch-and-reload
  :jsload-callback (fn [] (print "reloaded")))

(dc/start-figwheel-reloader!)
