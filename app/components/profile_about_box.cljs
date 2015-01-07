(ns components.profile-about-box)



(defn profile-about-box
  "A box with basic information regarding user"
  [firstname lastname email]
  [:div
   [:div "First name:"
    [:div firstname]]
   [:div "Last name:"
    [:div lastname]]
   [:div "Email:"
    [:div email]]])
