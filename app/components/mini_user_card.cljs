(ns components.mini-user-card)



(defn mini-user-card
  "A mini card to display info of a single user."
  [selected on-click user]
  [:div {:style {:backgroundColor (if selected "#333" "#fff")}}
   [:img {:src (:img user)}]
   [:a {:href "" :on-click #(do (.preventDefault %) (on-click))}
    (:full-name user)]])
