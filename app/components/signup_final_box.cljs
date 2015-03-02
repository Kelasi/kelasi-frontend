(ns components.signup-final-box
  (:require [reagent.core :as r]
            [widgets.media :refer (media)]
            [widgets.button :refer (button)]
            [widgets.input :refer (input)]
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
        [media (:img introducer) (:full-name introducer) identity]]

       [:p "First name"
        [input :text firstname]]

       [:p "Last name"
        [input :text lastname]]

       [:p "University name"
        [input :text university]]

       [:p "Email"
        [input :text email]]

       [:p "Password"
        [input :password password]]

       [:p "Retype password"
        [input :password re-password]]

       [button "Singup!" #(signup {:source ::signup-final-box
                                   :firstname @firstname
                                   :lastname @lastname
                                   :university @university
                                   :email @email
                                   :password @password
                                   :introducer-id (:id introducer)})]])))
