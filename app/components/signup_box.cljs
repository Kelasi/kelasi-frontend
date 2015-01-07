(ns kelasi-frontend.components.signup-box
  (:require [reagent.core :as r]
            [kelasi-frontend.components.find-friends-box
             :refer (find-friends-box)]
            [kelasi-frontend.components.found-friends-box
             :refer (found-friends-box)]
            [kelasi-frontend.components.signup-final-box
             :refer (signup-final-box)]
            [kelasi-frontend.components.signup-progress-breadcrumb
             :refer (signup-progress-breadcrumb)]
            [kelasi-frontend.actions :refer (search-introducer)]))



(defn signup-box
  "First page's signup box"
  [people all-users]
  (let [stage (r/atom 1)
        introducer (r/atom nil)]
    (fn [_ _]
      [:div
       (case @stage
         1 [find-friends-box
            (fn [firstname lastname university]
              (search-introducer {:source ::signup-box
                                  :firstname firstname
                                  :lastname lastname
                                  :university university})
              (reset! stage 2))]
         2 [found-friends-box people all-users
            (fn [intr]
              (reset! introducer intr)
              (reset! stage 3))]
         3 [signup-final-box @introducer]
         nil)

       [signup-progress-breadcrumb @stage #(reset! stage %)]])))
