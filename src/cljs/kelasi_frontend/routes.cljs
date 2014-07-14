(ns kelasi-frontend.routes
  (:require-macros [cljs.core.async.macros :refer (go)]
                   [secretary.core :refer (defroute)])
  (:require
    [secretary.core :as secretary]
    [kelasi-frontend.utilities :refer (listen)]
    [cljs.core.async :refer (<!)]
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

(go (-> (listen history EventType/NAVIGATE)
        <!
        .-token
        secretary/dispatch!))


(let [func (fn [e]
             (let [path (->> (.. e -target -href)
                             (.parse Uri)
                             (.getPath))
                   title (.. e -target -title)]
               (when (secretary/locate-route path)
                 (.setToken history path title)
                 (.preventDefault e))))]
  (go (<! (listen js/document "click"
                  :transform func))))
