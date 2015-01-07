(ns components.signup-final-box
  (:require [reagent.core :as r]
            [components.mini-user-card :refer (mini-user-card)]
            [actions :refer (signup)]))



(defn signup-final-box
  "Final step of registration."
  [introducer]
  (let [firstname   (r/atom "")
        lastname    (r/atom "")
        university  (r/atom "")
        email       (r/atom "")
        password    (r/atom "")
        re-password (r/atom "")]
    (fn [_]
      [:div
       [:p "You said you know:"
        [mini-user-card false identity introducer]]

       [:p "First name"
        [:input {:type "text"
                 :value @firstname
                 :on-change #(reset! firstname (.-target.value %))}]]

       [:p "Last name"
        [:input {:type "text"
                 :value @lastname
                 :on-change #(reset! lastname (.-target.value %))}]]

       [:p "University name"
        [:input {:type "text"
                 :value @university
                 :on-change #(reset! university (.-target.value %))}]]

       [:p "Email"
        [:input {:type "text"
                 :value @email
                 :on-change #(reset! email (.-target.value %))}]]

       [:p "Password"
        [:input {:type "password"
                 :value @password
                 :on-change #(reset! password (.-target.value %))}]]

       [:p "Retype password"
        [:input {:type "password"
                 :value @re-password
                 :on-change #(reset! re-password (.-target.value %))}]]

       [:button {:type "button"
                 :on-click #(signup {:source ::signup-final-box
                                     :firstname @firstname
                                     :lastname @lastname
                                     :university @university
                                     :email @email
                                     :password @password
                                     :introducer-id (:id introducer)})}
        "Singup!"]])))
