(ns config
  (:require [devcards.core :as dc :include-macros true]
            [figwheel.client :as fw :include-macros true]

            ; Fake server
            [mocks.server :as server]

            ; Echo store
            [mocks.echo-store]

            ; Component devcards
            [kelasi-frontend.components.root-devcards]
            [kelasi-frontend.components.login-box-devcards]
            [kelasi-frontend.components.signup-box-devcards]
            [kelasi-frontend.components.login-signup-box-devcards]
            [kelasi-frontend.components.find-friends-box-devcards]
            [kelasi-frontend.components.mini-user-card-devcards]
            [kelasi-frontend.components.signup-progress-breadcrumb-devcards]
            [kelasi-frontend.components.found-friends-box-devcards]
            [kelasi-frontend.components.signup-final-box-devcards]

            ; Stores
            [kelasi-frontend.stores.users]
            [kelasi-frontend.stores.search]
            [kelasi-frontend.stores.routes]
            [kelasi-frontend.stores.errors]
            ))

(enable-console-print!)

(dc/start-devcard-ui!)

#_(fw/watch-and-reload
  :jsload-callback (fn [] (print "reloaded")))

(dc/start-figwheel-reloader!)
