(ns kelasi-frontend.backend.search
  (:require-macros [cljs.core.async.macros :refer (go)])
  (:require [kelasi-frontend.backend.core :refer (send)]
            [kelasi-frontend.actions :as actions]
            [cljs.core.async :refer (<!)]))



(defn people
  "Search for people in server"
  [firstname lastname university]
  )
#_(defn login
  "Try to login with server"
  [username password]
  (go (let [request (send "POST"
                          "/api_/session.json"
                          {:username username
                           :password password})
            respond (<! request)]
        (condp = ((juxt first second) respond)
          [:success 200] (let [user (respond 2)]
                     (actions/load-user :source ::login
                                        :user   user)
                     (actions/login :source  ::login
                                    :user-id (:id user)))
          [:error 401] (actions/wrong-login :source ::login)
          (actions/net-error :source ::login
                             :orig   `(login ~username ~password))))))
