(ns components.post-list
  (:require [widgets.list :as wlst]
            [widgets.media :refer (media)]))



(defn post-list
  "List of timeline posts"
  [posts all-users]
  (let [tr (fn [ps]
             (map (juxt identity #(get all-users (:user-id %))) ps))
        wc (fn wc [[post user]]
             [:div
              [media (:img user) (:full-name user)]
              [:div (:body post)]
              [wlst/list (tr (:replies post)) wc]])]
    [wlst/list (tr posts) wc]))
