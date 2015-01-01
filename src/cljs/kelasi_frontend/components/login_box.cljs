(ns kelasi-frontend.components.login-box
  (:require [reagent.core :as r]
            [kelasi-frontend.actions :refer (try-login)]))



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

       [:p "User name"
        [:input {:type "text"
                 :value @username
                 :on-change #(reset! username (.-target.value %))}]]
       [:p "Password"
        [:input {:type "password"
                 :value @password
                 :on-change #(reset! password (.-target.value %))}]]
       [:input {:type "checkbox"
                :checked @remember-me
                :on-change #(swap! remember-me not)}]
       [:p "Remember me!"]
       [:button {:type "button"
                 :on-click #(try-login {:source   ::login-box
                                        :username @username
                                        :password @password})}
        "Login"]])))
