(ns kelasi-frontend.routes
  (:require
    [secretary.core :as secretary :include-macros true :refer  [defroute]]
    [goog.events :as events]
    [goog.history.EventType :as EventType])
  (:import goog.history.Html5History
           goog.Uri))

(defroute home-path "/" []
  (js/console.log "We are at home!"))

(defroute sub-path "/:path" [path]
  (js/console.log "We are at " path))

(def history (Html5History.))

(doto history
  (.setUseFragment false)
  (.setPathPrefix "")
  (.setEnabled true))

(events/listen history EventType/NAVIGATE
                    #(secretary/dispatch! (.-token %)))

(events/listen js/document "click"
               (fn [e]
                 (let [path (->> (.. e -target -href) (.parse Uri) (.getPath))
                       title (.. e -target -title)]
                   (when (secretary/locate-route path)
                     (.setToken history path title)
                     (.preventDefault e)))))

