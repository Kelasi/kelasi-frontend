(ns mocks.server
  (:require [mocks.user :as user]
            [mocks.post :as post]
            [mocks.timeline :as timeline]))


(def ^:private server
  "The handler to fake server"
  (.create js/sinon.fakeServer))

(set! (.-autoRespond server) true)

#_(defn bring-up
  "Bring up a new fake server"
  [& {:keys [auto-serve]
      :or {auto-serve false}}]
  (reset! server (.create js/sinon.fakeServer))
  (set! (.-autoRespond @server) auto-serve))

#_(defn take-down
  "Take down the fake server"
  []
  (.restore @server)
  (reset! server nil))

#_(defn respond
  "Deliver pending requests"
  []
  (.respond @server))


(defn- GET [path]
  ["GET" (str "/api_/" path ".json")])

(defn- POST [path]
  ["POST" (str "/api_/" path ".json")])

(defn- PUT [path]
  ["PUT" (str "/api_/" path ".json")])

(defn- DELETE [path]
  ["DELETE" (str "/api_/" path ".json")])

(defn- response-json [obj]
  #js [200 #js {"Content-Type" "application/json"}
       (.stringify js/JSON (clj->js obj))])


(def routes
  "Hash of routes to responses"
  {(POST "session") (response-json user/user1)
   (POST "search/people") (response-json [user/user1])
   (POST "users") (response-json user/user1)
   (POST "timelines/1/posts") (response-json post/post1)
   (GET  "timelines/1") (response-json timeline/timeline1)
   })

(defn fake
  "Fake the given or all available routes"
  ([] (apply fake (keys routes)))
  ([& to-fake]
   (doseq [[method uri resp :as k] to-fake]
     (.respondWith server method uri (or resp (get routes k))))))

(fake)
