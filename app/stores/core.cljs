(ns stores.core
  (:require [state :refer (app-state)]))



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
