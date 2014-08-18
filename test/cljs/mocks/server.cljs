(ns mocks.server)


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
  {(POST "session") #js [200 #js {"Content-Type" "application/text"} "Testing it"]
   })

(defn fake
  "Fake the given or all available routes"
  ([] (apply fake (keys routes)))
  ([& to-fake]
   (doseq [[method uri :as k] to-fake]
     (.respondWith server method uri (get routes k)))))

(fake)
