(ns pages.notfound)



(defn notfound
  "404 page"
  [opts]
  [:div
   "The page you are looking for: "
   [:em (get-in opts [:params :path])]
   "Does not exist."])
