(ns kelasi-frontend.stores.routes
  (:require-macros [cljs.core.async.macros :refer (go-loop go)])
  (:require [kelasi-frontend.state :refer (app-state)]
            [kelasi-frontend.stores.core :refer (store set-in!)]
            [dispatcher.core :refer (process)]
            [kelasi-frontend.stores.users :as users]
            [router.core :refer (navigate!)]
            [cljs.core.async :refer (<! >! chan tap mult)]))



;; Store

(def routes (store [:routes]))



;; Here we will listen to the actions users store processed

(def users-done (chan))

(let [u-done (chan)]
  (tap users/done u-done)

  (go-loop [[action] (<! u-done)]

    ; When it is of desired type, put it in the users-done
    (when (= :login (first action))
      (>! users-done action))

    (recur (<! u-done))))



;; response function

(defmulti <response (fn [action _] action))

(defmethod <response :default
  [_ _]
  (go nil))

(defmethod <response :login
  [& action]
  (go (let [wait-for-user (<! users-done)
            user-id (:user-id (second action))
            path [:users :all-users user-id :profile-name]
            profile-name (get-in @app-state path)]
        (when (not=  wait-for-user action)
          (.error js/console (str "Users and routes stores are out of sync:"
                                  "Users action:" action
                                  "Routes action:" wait-for-user)))
        (navigate! (str "/profile/" profile-name)))
      nil))

(defmethod <response :show-timeline
  [_ action]
  (go (let [timeline-id (:timeline-id action)]
        (navigate! (str "/timeline/" timeline-id)))
      nil))



;; Listen for actions (main loop)

(def done
  "Processed actions channel"
  (mult (process <response)))
