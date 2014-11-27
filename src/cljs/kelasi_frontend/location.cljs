(ns kelasi-frontend.location
  (:require-macros [cljs.core.async.macros :refer (go go-loop)])
  (:require [kelasi-frontend.utilities :refer (listen)]
            [cljs.core.async :refer (<!)]
            [goog.history.EventType :as EventType])
  (:import [goog.history Html5History]
           [goog Uri]))



;; The main history manager
(def history (Html5History.))



;; Set defaults and enable html5 history api
(doto history
  (.setUseFragment false)
  (.setPathPrefix "")
  (.setEnabled true))



;; Listen for navigation events and dispatch to router
#_(go (-> (listen history EventType/NAVIGATE)
        <!
        .-token
        secretary/dispatch!))



(defn current-route
  "Get the current route"
  []
  (.getToken history))



(defn change-route
  "Change route token of current url"
  [path]
  (.setToken history path))



;; Prevent links from redirecting.
#_(let [func (fn [e]
             (let [path (->> (.. e -target -href)
                             (.parse Uri)
                             (.getPath))
                   title (.. e -target -title)]
               (when (secretary/locate-route path)
                 (.setToken history path title)
                 (.preventDefault e))
               e))]
  (go-loop []
           (<! (listen js/document "click"
                  :transform func))
           (recur)))
