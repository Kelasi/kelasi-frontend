;;; This namespace is for creating the connection with the browser. It
;;; lives in the dev-resources/tools/brepl directory. It is used in the
;;; :dev profile only.
(ns brepl.connect
  (:require [weasel.repl :as ws-repl]))

(ws-repl/connect "ws://localhost:9001" :verbose true)
