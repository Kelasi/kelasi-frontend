(ns kelasi-frontend.components.notfound-page)



(defn notfound-page
  "404 page"
  [opts]
  [:div
   "The page you are looking for: "
   [:em (get-in opts [:params :path])]
   "Does not exist."])
