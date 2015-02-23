(ns components.login-box
  (:require [reagent.core :as r]
            [widgets.input :refer (input)]
            [actions :refer (try-login)]))



(defn login-box
  "First page's login box"
  [errors]
  (let [username    (r/atom "")
        password    (r/atom "")
        remember-me (r/atom false)]
    (fn [_]
      [:div
       (cond
         (= (get errors :login) :wrong-login)
         [:p {:style {:color "red"}} "Wrong username/password"]

         (get errors :network)
         [:p {:style {:color "red"}} "Request failed. retry!"])

       [:div "User name"
        [input :text username]]

       [:div "Password"
        [input :password password]]

       [input :checkbox remember-me]
       [:p "Remember me!"]

       [:button {:type "button"
                 :on-click #(try-login {:source   ::login-box
                                        :username @username
                                        :password @password})}
        "Login"]])))
