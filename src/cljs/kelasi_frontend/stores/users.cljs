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
  [id user]
  (swap! app-state
         assoc-in [:users :all-users id]
         user))



;; State extractions

(defn get-user [id]
  (get-in @app-state [:users :all-users id]))


;; Action response functions

(defn- do-try-login
  "try_login action has been received."
  [{:keys [user-name password]}]
  (set-in [:current_user] :loading)
  (session/login user-name password))

(defn- do-load-user
  "load-user action has been received."
  [{:keys [id] :as user}]
  (set-user id user))



;; Listen for actions (main loop)

(go (while true
      (let [action (<! actions-chan)]
        (condp = (:action action)
          :try-login (do-try-login (:payload action))
          :load-user (do-load-user (:payload action))
          nil))))
