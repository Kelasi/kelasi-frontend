(ns config
  (:require [devcards.core :as dc :include-macros true]
            [figwheel.client :as fw :include-macros true]

            ; Fake server
            [mocks.server :as server]

            ; Component devcards
            [kelasi-frontend.components.root-devcards]
            [kelasi-frontend.components.login-box-devcards]

            ; Stores
            [kelasi-frontend.stores.users]
            [kelasi-frontend.stores.routes]
            [kelasi-frontend.stores.errors]
            ))

(enable-console-print!)

(dc/start-devcard-ui!)

#_(fw/watch-and-reload
  :jsload-callback (fn [] (print "reloaded")))

(dc/start-figwheel-reloader!)
