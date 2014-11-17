(ns mocks.echo-store
  (:require-macros [cljs.core.async.macros :refer (go go-loop)])
  (:require [kelasi-frontend.stores.core :refer (process)]
            [cljs.core.async :refer (<!)]))



(def store-ch (process (fn [a]
                         (pr a)
                         (go nil))))

(go-loop []
         (<! store-ch)
         (recur))
