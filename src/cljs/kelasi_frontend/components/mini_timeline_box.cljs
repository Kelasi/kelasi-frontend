(ns kelasi-frontend.components.mini-timeline-box
  (:require [om-tools.core :as omtool :include-macros true]
            [om-tools.dom  :as dom    :include-macros true]))



(omtool/defcomponentk mini-timeline-box
  "Mini Timeline Card"
  [data]
  (render
    [_]
    (dom/div {:class "mini-timeline"}
      (dom/div {:class "cover"}
        (dom/img {:class "cover-photo"
                  :src (:cover-photo-mini data)})

        (dom/h4 {:class "timeline-title"} (:title data)))

      (dom/div {:class "head"}
        (dom/ul {:class "headlines"}
          (dom/li (str "Followers:" (:followers-no data)))
          (dom/li (str "Posts:" (:posts-no data))) )

        (dom/img {:class "profile-photo"
                  :src (:profile-photo-thumb data)})))))
