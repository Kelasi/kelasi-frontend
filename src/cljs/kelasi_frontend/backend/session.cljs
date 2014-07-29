(ns kelasi-frontend.backend.session
  (:require [shoreleave.remote :refer (request)]))



(defn login [username password]
  (request [:post (str "/session")]
           :content {:username username
                     :password password}
           :on-success (.-log js/console)
           :on-error   (.-log js/console)))
