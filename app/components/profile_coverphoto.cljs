(ns components.profile-coverphoto
  (:require [widgets.coverphoto :refer (coverphoto)]))



(defn profile-coverphoto
  "Cover photo of the profile page"
  [user]
  [coverphoto (:img user) (:profile-name user)])
