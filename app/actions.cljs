(ns kelasi-frontend.actions
  (:require [dispatcher.core :include-macros true
             :refer-macros (defaction)]
            [schema.core :as s :include-macros true]))



(defaction try-login
  "View - When user submits login box"
  {:source   s/Keyword
   :username s/Str
   :password s/Str})

(defaction load-user
  "Backend - When the server send user"
  {:source s/Keyword
   :user   {s/Any s/Any}})

(defaction login
  "Backend - When user logs in with the backend"
  {:source  s/Keyword
   :user-id s/Str})

(defaction wrong-login
  "Backend - When username/password is wrong"
  {:source s/Keyword})

(defaction net-error
  "Backend - Whenever something goes wrong with a request"
  {:source s/Keyword
   :orig   s/Any})

(defaction search-introducer
  "View - When during registration user searches for somebody familiar"
  {:source     s/Keyword
   :firstname  s/Str
   :lastname   s/Str
   :university s/Str})

(defaction load-search-result
  "Backend - When a search result comes in"
  {:source s/Keyword
   :category s/Keyword
   :result [s/Str]})

(defaction signup
  "View - When user tries to signup"
  {:source s/Keyword
   :firstname s/Str
   :lastname s/Str
   :university s/Str
   :email s/Str
   :password s/Str
   :introducer-id s/Str})

(defaction search-all
  "View - When user searches in the first page"
  {:source s/Keyword
   :q s/Str})

(defaction show-self-profile
  "View - When user clicks on his own name"
  {:source s/Keyword})

(defaction new-post
  "View - When a user posts on a timeline"
  {:source s/Keyword
   :timeline-id s/Str
   :parent-id s/Str
   :body s/Str})

(defaction load-post
  "Backend - When a new post arrives from server"
  {:source s/Keyword
   :post {s/Any s/Any}})

(defaction show-timeline
  "View - When a user click on a timeline link"
  {:source s/Keyword
   :timeline-id s/Str})

(defaction show-user-profile
  [& {:as params}]
  {:source s/Keyword
   :user-id s/Str})

(defaction load-timeline
  "Backend - When the server send a timeline"
  {:source s/Keyword
   :timeline {s/Any s/Any}})

(defaction change-page
  "Router - When router tries to change the page"
  {:source s/Keyword
   :page (s/pred ifn?)
   :params []})
