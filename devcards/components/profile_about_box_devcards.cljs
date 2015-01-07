(ns components.profile-about-box-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [components.profile-about-box :refer (profile-about-box)]
            [reagent.core :as r]
            [devcards.core :as dc :include-macros true]))



(defcard profile-about-box-component
  (dc/react-card (r/as-element [profile-about-box "John" "Doe" "john@doe.com"])))
