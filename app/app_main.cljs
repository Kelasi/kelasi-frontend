(ns app-main
  (:require [router.core :as router]
            [router.react :as r-react]
            [state :refer (app-state)]
            [actions :refer (change-page)]
            [pages.entrance :refer (entrance)]
            [components.profile-page :refer (profile-page)]
            [components.timeline-page :refer (timeline-page)]
            [pages.search :refer (search)]
            [components.notfound-page :refer (notfound-page)])
  (:require-macros [router.reagent :refer (match)]))



(enable-console-print!)



(match "/" p [entrance @app-state p])
(match "/profile/:name" p [profile-page @app-state p])
(match "/timeline/:name" p [timeline-page @app-state p])
(match "/search/:q" p [search @app-state p])
(match "/*path" p [notfound-page @app-state p])



(router/config!)
(r-react/initiate!
  (.getElementById js/document "app")
  (fn [relem params]
    (change-page {:source ::app
                  :page relem
                  :params params})
    [relem params]))
