(ns kelasi-frontend.stores.core
  (:require-macros [cljs.core.async.macros :refer (go-loop)])
  (:require [cljs.core.async :refer (chan <! >! tap)]
            [kelasi-frontend.dispatcher :as dispatcher]
            [kelasi-frontend.state :refer (app-state)]))



(defn process
  "Gets a function, which will be called with the recieved actions.
  The function should return a channel with the result of process.
  Returns a channel, which will be filled with the processed actions."
  [responder]
  (let [actions-ch (chan)
        done-ch    (chan)]
    (tap dispatcher/actions actions-ch)
    (go-loop [action (<! actions-ch)]
      (let [result (<! (responder action))]
        (>! done-ch (merge action {:result result})))
      (recur (<! actions-ch)))
    done-ch))



(defn store
  "Gets a path and returns an atom like to represent that path"
  [path]
  (reify
    IDeref
    (-deref [_] (get-in @app-state path))

    ISwap
    (-swap! [o f] (swap! app-state update-in path f))
    (-swap! [o f a] (swap! app-state update-in path f a))
    (-swap! [o f a b] (swap! app-state update-in path f a b))
    (-swap! [o f a b xs] (swap! app-state update-in path f a b xs))))



(defn set-in!
  "Set a value in a subpath of a store"
  [st path value]
  (swap! st assoc-in path value))
