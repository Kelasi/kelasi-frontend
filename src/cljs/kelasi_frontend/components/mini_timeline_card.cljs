(ns kelasi-frontend.components.mini-timeline-card
  (:require [om-tools.core :as omtool :include-macros true]
            [om-tools.dom  :as dom    :include-macros true]))



(omtool/defcomponentk mini-timeline-card
  "Mini Timeline Card"
  [[:data timeline admin on-click]]
  (render
    [_]
    (dom/div {:class "mini-timeline"
              :on-click on-click}
      (dom/div {:class "cover"}
        (dom/img {:class "cover-photo"
                  :src (:cover-photo-mini timeline)})

        (dom/h4 {:class "timeline-title"} (:title timeline)))

      (dom/div {:class "head"}
        "Admin:"
        (dom/img {:class "profile-photo"
                  :src (:img admin)})
        (:full-name admin)))))
