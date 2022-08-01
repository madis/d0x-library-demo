(ns library-demo.ipfs.demo
  (:require
    [clojure.core.async :as async :refer [<! >! chan close! go put!] :include-macros true]
    [library-demo.ipfs.ethlance-server-ipfs :as ethl-ipfs]))

(defn run-demo []
  (let [response-add (atom nil)
        result-add (atom nil)]
    (reset! response-add (ethl-ipfs/add-edn! {:hello "World" :answer 42 :things [1 2 3]}))
    (println "response-add: " @response-add)
    (go
      (async/take! (first @response-add) #(reset! result-add %))
      (println ">>> result-add: " @result-add)
      (go (async/take! (second @response-add) #(reset! result-add %)))
      (println ">>> result-add: " @result-add))))
