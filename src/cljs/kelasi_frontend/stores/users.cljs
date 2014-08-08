(ns kelasi-frontend.stores.users
  (:require-macros [cljs.core.async.macros :refer (go)])
  (:require [kelasi-frontend.state :refer (app-state)]
            [kelasi-frontend.dispatcher :refer (create-chan)]
            [kelasi-frontend.backend.session :as session]
            [cljs.core.async :refer (<!)]))



;; All actions come through this channel

(def actions-chan (create-chan))



;; State manipulation functions

(defn- set-in
  "Set the value in the subpath of app-state"
  [subpath value]
  (assert (vector? subpath))
  (swap! app-state
         assoc-in (cons :users (seq subpath))
         value))

(defn- set-user
  "Set the user under the all-users of app-state"
  [{id :id :as user}]
  (set-in [:all-users id] user))



;; Local aggregation functions

(defn- getin
  "Get a value from local state"
  [subpath]
  (get-in (:users @app-state) subpath))

(defn- get-user
  "Get the user with specified id from under all-users key"
  [id]
  (getin [:all-users id]))



;; Action response functions

(defn- do-try-login
  "try_login action has been received."
  [{:keys [username password]}]
  (set-in [:current-user] :loading)
  (session/login username password))

(defn- do-load-user
  "load-user action has been received."
  [{:keys [user]}]
  (set-user user))

(defn- do-login
  "login action has been received."
  [{:keys [user-id]}]
  (set-in [:current-user] (get-user user-id)))


;; Listen for actions (main loop)

(go (while true
      (let [action (<! actions-chan)]
        (condp = (:action action)
          :try-login (do-try-login action)
          :load-user (do-load-user action)
          :login     (do-login     action)
          nil))))
