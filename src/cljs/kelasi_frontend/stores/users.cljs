(ns kelasi-frontend.stores.users
  (:require-macros [cljs.core.async.macros :refer (go)])
  (:require [kelasi-frontend.state :refer (app-state)]
            [kelasi-frontend.stores.core :refer (process store set-in!)]
            [kelasi-frontend.backend.session :as session]
            [cljs.core.async :refer (mult)]))



;; Store

(def users (store [:users]))



;; State manipulation functions

(defn- set-user
  "Set the user under the all-users of app-state"
  [{id :id :as user}]
  (set-in! users [:all-users id] user))



;; Local aggregation functions

(defn- get-user
  "Get the user with specified id from under all-users key"
  [id]
  (get-in @users [:all-users id]))



;; Action response functions

(defmulti action-response :action)

(defmethod action-response :default
  [_]
  (go nil))

(defmethod action-response :try-login
  [{:keys [username password]}]
  (set-in! users [:current-user] :loading)
  (session/login username password)
  (go nil))

(defmethod action-response :load-user
  [{:keys [user]}]
  (set-user user)
  (go nil))

(defmethod action-response :login
  [{:keys [user-id]}]
  (set-in! users [:current-user] (get-user user-id))
  (go nil))

(defmethod action-response :wrong-login
  [_]
  (set-in! users [:current-user] nil)
  (go nil))



;; The main loop to listen to actions

(def done
  "The mult of processed actions"
  (mult (process action-response)))
