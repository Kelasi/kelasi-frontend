(ns components.login-signup-box
  (:require [reagent.core :as r]
            [components.login-box :refer (login-box)]
            [components.signup-box :refer (signup-box)]))



(defn login-signup-box
  "First page's sidebar"
  [search users errors]
  (let [position (r/atom :up)]
    (fn [_ _ _]
      [:div
       (when (= :up @position)
         [login-box errors])

       [:a {:href ""
            :on-click (fn [ev]
                        (.preventDefault ev)
                        (reset! position (if (= @position :up) :down :up)))}
        "Swap login/signup"]

       (when (= :down @position)
         [signup-box (:people search) (:all-users users)])])))
