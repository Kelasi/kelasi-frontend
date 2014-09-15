(ns kelasi-frontend.components.find-friends-box
  (:require [om-tools.core :as omtool :include-macros true]
            [om-tools.dom  :as dom    :include-macros true]
            [kelasi-frontend.actions :refer (search-introducer)]))



(omtool/defcomponentk find-friends-box
  "First step of registration."
  [data owner state]
  (init-state
   [_]
   {:firstname  ""
    :lastname   ""
    :university ""})
  (render
   [_]
   (dom/div
     (dom/p "Enter your friend's data:")

     (dom/p "First name:"
            (dom/input
              {:type "text"
               :value (:firstname @state)
               :on-change #(swap! state
                                  assoc :firstname
                                  (.. % -target -value))}))

     (dom/p "Last name:"
            (dom/input
              {:type "text"
               :value (:lastname @state)
               :on-change #(swap! state
                                  assoc :lastname
                                  (.. % -target -value))}))

     (dom/p "University name:"
            (dom/input
              {:type "text"
               :value (:university @state)
               :on-change #(swap! state
                                  assoc :university
                                  (.. % -target -value))}))

     (dom/button
       {:type "button"
        :on-click #(search-introducer :source     ::find-friends-box
                                      :firstname  (:firstname  @state)
                                      :lastname   (:lastname   @state)
                                      :university (:university @state))}
       "Search"))))
