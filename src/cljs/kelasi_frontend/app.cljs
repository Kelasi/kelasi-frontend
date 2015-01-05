(ns kelasi-frontend.app
  (:require [router.core :as router]
            [router.react :as r-react]
            [kelasi-frontend.state :refer (app-state)]
            [kelasi-frontend.actions :refer (change-page)]
            [kelasi-frontend.components.entrance-page :refer (entrance-page)]
            [kelasi-frontend.components.profile-page :refer (profile-page)]
            [kelasi-frontend.components.timeline-page :refer (timeline-page)]
            [kelasi-frontend.components.search-page :refer (search-page)]
            [kelasi-frontend.components.notfound-page :refer (notfound-page)])
  (:require-macros [router.reagent :refer (match)]))



(enable-console-print!)



(match "/" p [entrance-page @app-state p])
(match "/profile/:name" p [profile-page @app-state p])
(match "/timeline/:name" p [timeline-page @app-state p])
(match "/search/:q" p [search-page @app-state p])
(match "/*path" p [notfound-page @app-state p])



(router/config!)
(r-react/initiate!
  (.getElementById js/document "app")
  (fn [relem params]
    (change-page {:source ::app
                  :page relem
                  :params params})
    [relem params]))
