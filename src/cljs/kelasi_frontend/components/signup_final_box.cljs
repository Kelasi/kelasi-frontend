(ns kelasi-frontend.components.signup-final-box
  (:require [om-tools.core :as omtool :include-macros true]
            [om-tools.dom  :as dom    :include-macros true]
            [om.core       :as om     :include-macros true]
            [kelasi-frontend.components.mini-user-card :refer (mini-user-card)]
            [kelasi-frontend.actions :refer (signup)]))



(omtool/defcomponentk signup-final-box
  "Final step of registration."
  [[:data introducer] owner state]
  (init-state
   [_]
   {:firstname   ""
    :lastname    ""
    :university  ""
    :email       ""
    :password    ""
    :re-password ""})
  (render
   [_]
   (dom/div
     (dom/p "You said you know:"
            (om/build mini-user-card {:selected false
                                      :user introducer
                                      :on-click identity}))
     (dom/p "First name"
            (dom/input
              {:type "text"
               :value (:firstname @state)
               :on-change #(swap! state
                                  assoc :firstname
                                  (.. % -target -value))}))
     (dom/p "Last name"
            (dom/input
              {:type "text"
               :value (:lastname @state)
               :on-change #(swap! state
                                  assoc :lastname
                                  (.. % -target -value))}))
     (dom/p "University name"
            (dom/input
              {:type "text"
               :value (:university @state)
               :on-change #(swap! state
                                  assoc :university
                                  (.. % -target -value))}))
     (dom/p "Email"
            (dom/input
              {:type "text"
               :value (:email @state)
               :on-change #(swap! state
                                  assoc :email
                                  (.. % -target -value))}))
     (dom/p "Password"
            (dom/input
              {:type "password"
               :value (:password @state)
               :on-change #(swap! state
                                  assoc :password
                                  (.. % -target -value))}))
     (dom/p "Retype password"
            (dom/input
              {:type "password"
               :value (:re-password @state)
               :on-change #(swap! state
                                  assoc :re-password
                                  (.. % -target -value))}))
     (dom/button
       {:type "button"
        :on-click #(signup (-> @state
                               (select-keys [:firstname :lastname
                                             :university :email
                                             :password])
                               (assoc :source ::signup-final-box
                                      :introducer-id (:id @introducer))
                               ((partial mapcat identity))))}
       "Singup!"))))
