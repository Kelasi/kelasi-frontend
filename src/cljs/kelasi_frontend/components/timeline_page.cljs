(ns kelasi-frontend.components.timeline-page
  (:require [om-tools.core :as omtool :include-macros true]
            [om-tools.dom  :as dom    :include-macros true]
            [om.core       :as om     :include-macros true]
            [reagent.core :as r]
            [kelasi-frontend.components.navbar :refer (navbar)]
            [kelasi-frontend.components.timeline-about-box
             :refer (timeline-about-box)]
            [kelasi-frontend.components.new-post-box :refer (new-post-box)]
            [kelasi-frontend.components.post-list :refer (post-list)]
            [kelasi-frontend.components.coverphoto-box
             :refer (coverphoto-box)]))



(omtool/defcomponentk timeline-page
  "Timeline page"
  [[:data users timeline posts] owner state]
  (render
    [_]
    (dom/div
      (om/build navbar (select-keys users [:current-user]))
      (r/as-element
        (coverphoto-box (:cover-image timeline) (:title timeline)))
      (om/build timeline-about-box (select-keys timeline [:title]))
      (om/build new-post-box {:timeline-id (:id timeline)
                              :parent-id "0"})
      (r/as-element (post-list posts (:all-users users))))))
