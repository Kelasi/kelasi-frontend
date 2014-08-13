(ns kelasi-frontend.stores.users
  (:require-macros [cljs.core.async.macros :refer (go-loop)])
  (:require [kelasi-frontend.state :refer (app-state)]
            [kelasi-frontend.dispatcher :refer (actions)]
            [kelasi-frontend.backend.session :as session]
            [cljs.core.async :refer (<! chan tap)]))



;; All actions come through this channel

(def actions-chan (chan))
(tap actions actions-chan)



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

(defmulti action-response :action)

(defmethod action-response :default
  [_]
  nil)

(defmethod action-response :try-login
  [{:keys [username password]}]
  (set-in [:current-user] :loading)
  (session/login username password))

(defmethod action-response :load-user
  [{:keys [user]}]
  (set-user user))

(defmethod action-response :login
  [{:keys [user-id]}]
  (set-in [:current-user] (get-user user-id)))


;; Listen for actions (main loop)

(go-loop []
  (action-response (<! actions-chan))
  (recur))
