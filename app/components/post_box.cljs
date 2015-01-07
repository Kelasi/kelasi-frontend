(ns components.post-box)



(defn post-box
  "A box for showing a post and its replies"
  [post all-users]
  [:div
   ; User info section
   (let [user (all-users (:user-id post))]
     [:div
      [:img {:src (:img user)}]
      (:full-name user)])
   ; Post body
   [:div (:body post)]
   ; Replies
   (for [reply (:replies post)]
     [post-box reply all-users])])
