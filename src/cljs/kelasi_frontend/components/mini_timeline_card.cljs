(ns kelasi-frontend.components.mini-timeline-card)



(defn mini-timeline-card
  "Mini Timeline Card"
  [timeline admin on-click]
  [:div.mini-timeline {:on-click on-click}
   [:div.cover
    [:img.cover-photo {:src (:cover-photo-mini timeline)}]
    [:h4.timeline-title (:title timeline)]]

   [:div.head
    "Admin:"
    [:img.profile-photo {:src (:img admin)}]
    (:full-name admin)]])
