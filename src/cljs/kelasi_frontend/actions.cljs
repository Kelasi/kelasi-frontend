(ns kelasi-frontend.actions
  (:require [kelasi-frontend.dispatcher :as dispatch]
            [schema.core :as s]))



(def try-login-schema
  {:source   s/Keyword
   :username s/Str
   :password s/Str})

(defn try-login
  "View - When user submits login box"
  [& {:as params}]
  (s/validate try-login-schema params)
  (dispatch/dispatch (assoc params :action :try-login)))



(def load-user-schema
  {:source s/Keyword
   :user   {s/Any s/Any}})

(defn load-user
  "Backend - When the server send user"
  [& {:as params}]
  (s/validate load-user-schema params)
  (dispatch/dispatch (assoc params :action :load-user)))



(def login-schema
  {:source  s/Keyword
   :user-id s/Str})

(defn login
  "Backend - When user logs in with the backend"
  [& {:as params}]
  (s/validate login-schema params)
  (dispatch/dispatch (assoc params :action :login)))



(def wrong-login-schema
  {:source s/Keyword})

(defn wrong-login
  "Backend - When username/password is wrong"
  [& {:as params}]
  (s/validate wrong-login-schema params)
  (dispatch/dispatch (assoc params :action :wrong-login)))



(def net-error-schema
  {:source s/Keyword
   :orig   s/Any})

(defn net-error
  "Backend - Whenever something goes wrong with a request"
  [& {:as params}]
  (s/validate net-error-schema params)
  (dispatch/dispatch (assoc params :action :net-error)))



(def search-introducer-schema
  {:source     s/Keyword
   :firstname  s/Str
   :lastname   s/Str
   :university s/Str})

(defn search-introducer
  "View - When during registration user searches for somebody familiar"
  [& {:as params}]
  (s/validate search-introducer-schema params)
  (dispatch/dispatch (assoc params :action :search-introducer)))



(def load-search-result-schema
  {:source s/Keyword
   :category s/Keyword
   :result [s/Str]})

(defn load-search-result
  "Backend - When a search result comes in"
  [& {:as params}]
  (s/validate load-search-result-schema params)
  (dispatch/dispatch (assoc params :action :load-search-result)))



(def signup-schema
  {:source s/Keyword
   :firstname s/Str
   :lastname s/Str
   :university s/Str
   :email s/Str
   :password s/Str
   :introducer-id s/Str})

(defn signup
  "View - When user tries to signup"
  [& {:as params}]
  (s/validate signup-schema params)
  (dispatch/dispatch (assoc params :action :signup)))



(def search-all-schema
  {:source s/Keyword
   :q s/Str})

(defn search-all
  "View - When user searches in the first page"
  [& {:as params}]
  (s/validate search-all-schema params)
  (dispatch/dispatch (assoc params :action :search-all)))



(def show-self-profile-schema
  {:source s/Keyword})

(defn show-self-profile
  "View - When user clicks on his own name"
  [& {:as params}]
  (s/validate show-self-profile-schema params)
  (dispatch/dispatch (assoc params :action :show-self-profile)))



(def new-post-schema
  {:source s/Keyword
   :timeline-id s/Str
   :parent-id s/Str
   :body s/Str})

(defn new-post
  "View - When a user posts on a timeline"
  [& {:as params}]
  (s/validate new-post-schema params)
  (dispatch/dispatch (assoc params :action :new-post)))



(def load-post-schema
  {:source s/Keyword
   :post {s/Any s/Any}})

(defn load-post
  "Backend - When a new post arrives from server"
  [& {:as params}]
  (s/validate load-post-schema params)
  (dispatch/dispatch (assoc params :action :load-post)))



(def show-timeline-schema
  {:source s/Keyword
   :timeline-id s/Int})

(defn show-timeline
  "View - When a user click on a timeline link"
  [& {:as params}]
  (s/validate show-timeline-schema params)
  (dispatch/dispatch (assoc params :action :show-timeline)))



(def load-timeline-schema
  {:source s/Keyword
   :timeline {s/Any s/Any}})

(defn load-timeline
  "Backend - When the server send a timeline"
  [& {:as params}]
  (s/validate load-timeline-schema params)
  (dispatch/dispatch (assoc params :action :load-timeline)))
