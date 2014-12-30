(ns kelasi-frontend.backend.users
  (:require-macros [cljs.core.async.macros :refer (go)])
  (:require [kelasi-frontend.backend.core :refer (send)]
            [kelasi-frontend.actions :as actions]
            [cljs.core.async :refer (<!)]))



(defn create
  "Create new user in server"
  [firstname lastname university email password introducer-id]
  (go (let [request (send "POST"
                          "/api_/users.json"
                          {:first_name firstname
                           :last_name  lastname
                           :university university
                           :email      email
                           :password   password
                           :introducer introducer-id})
            respond (<! request)]
        (condp = ((juxt first second) respond)
          [:success 200] (let [user (respond 2)]
                           (actions/load-user {:source ::create
                                               :user   user})
                           (actions/login {:source  ::create
                                           :user-id (:id user)}))
          (actions/net-error {:source ::create
                              :orig   `(create ~firstname
                                               ~lastname
                                               ~university
                                               ~email
                                               ~password
                                               ~introducer-id)})))))
