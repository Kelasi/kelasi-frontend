(ns config
  (:require [devcards.core :as dc :include-macros true]
            [figwheel.client :as fw]

            ; Fake server
            [mocks.server :as server]

            ; Echo store
            [mocks.echo-store]

            ; Page devcards
            [pages.entrance-devcards]
            [pages.search-devcards]
            [pages.timeline-devcards]
            [pages.profile-devcards]

            ; Component devcards
            [components.navbar-devcards]
            [components.login-box-devcards]
            [components.search-box-devcards]
            [components.signup-box-devcards]
            [components.login-signup-box-devcards]
            [components.find-friends-box-devcards]
            [components.signup-progress-breadcrumb-devcards]
            [components.found-friends-box-devcards]
            [components.timeline-list-box-devcards]
            [components.signup-final-box-devcards]
            [components.post-box-devcards]
            [components.post-list-devcards]
            [components.profile-about-box-devcards]
            [components.timeline-about-box-devcards]
            [components.new-post-box-devcards]

            ; Widgets
            [widgets.coverphoto-devcards]

            ; Stores
            [stores.users]
            [stores.posts]
            [stores.search]
            [stores.routes]
            [stores.errors]
            [stores.timelines]))

(enable-console-print!)

(dc/start-devcard-ui!)

#_(fw/watch-and-reload
  :jsload-callback (fn [] (print "reloaded")))

(dc/start-figwheel-reloader! {:websocket-url "ws://localhost:3449/figwheel-ws"})
