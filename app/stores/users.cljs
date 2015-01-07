(ns stores.users
  (:require-macros [cljs.core.async.macros :refer (go)])
  (:require [stores.core :refer (store set-in!)]
            [dispatcher.core :refer (process )]
            [backend.session :as session]
            [backend.users   :as users-be]
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

(defmulti <response (fn [action _] action))

(defmethod <response :default
  [_ _]
  (go nil))

(defmethod <response :try-login
  [_ {:keys [username password]}]
  (set-in! users [:current-user] :loading)
  (session/login username password)
  (go nil))

(defmethod <response :load-user
  [_ {:keys [user]}]
  (set-user user)
  (go nil))

(defmethod <response :login
  [_ {:keys [user-id]}]
  (set-in! users [:current-user] (get-user user-id))
  (go nil))

(defmethod <response :wrong-login
  [_ _]
  (set-in! users [:current-user] nil)
  (go nil))

(defmethod <response :signup
  [_ {:keys [firstname
           lastname
           university
           email
           password
           introducer-id]}]
  (users-be/create firstname lastname university email password introducer-id)
  (go nil))



;; The main loop to listen to actions

(def done
  "The mult of processed actions"
  (mult (process <response)))
