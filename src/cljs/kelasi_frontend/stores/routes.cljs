(ns kelasi-frontend.stores.routes
  (:require-macros [cljs.core.async.macros :refer (go-loop go)])
  (:require [kelasi-frontend.state :refer (app-state)]
            [kelasi-frontend.dispatcher :refer (actions)]
            [kelasi-frontend.stores.users :as users]
            [cljs.core.async :refer (<! >! chan tap)]))



;; Actions will be received through this channel

(def actions-chan (chan))
(tap actions actions-chan)



;; Here we will listen to the actions users store processed

(def users-done (chan))

(let [u-done (chan)]
  (tap users/done u-done)

  (go-loop [action (<! u-done)]

    ; When it is of desired type, put it in the users-done
    (when (= :login (:action action))
      (>! users-done action))

    (recur (<! u-done))))



;; State manipulation functions

(defn- set-in
  "Set the value under routes subpath"
  [subpath value]
  (assert (vector? subpath))
  (swap! app-state
         update-in [:routes]
         assoc-in subpath
         value))



;; response function

(defmulti response :action)

(defmethod response :default [_] nil)

(defmethod response :login [action]
  (go (let [wait-for-user (<! users-done)
            user-id (:user-id action)
            path [:users :all-users user-id :profile-name]
            profile-name (get-in @app-state path)]
        (when (not= wait-for-user action)
          (.error js/console (str "Users and routes stores are out of sync:"
                                  "Users action:" action
                                  "Routes action:" wait-for-user)))
        (set-in [:current] (str "/profile/" profile-name)))))



;; Listen for actions (main loop)

(go-loop []
  (response (<! actions-chan))
  (recur))
