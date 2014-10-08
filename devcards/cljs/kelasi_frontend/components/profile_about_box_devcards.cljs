(ns kelasi-frontend.components.profile-about-box-devcards
  (:require-macros [devcards.core :refer (defcard)])
  (:require [kelasi-frontend.components.profile-about-box :refer (profile-about-box)]
            [devcards.core :as dc :include-macros true]))



(defcard profile-about-box-component
  (dc/om-root-card profile-about-box {:firstname "John"
                                      :lastname "Doe"
                                      :email "john@doe.com"}))
