(ns library-demo.core
  (:require [library-demo.server-events-demo]))

(defn main [& cli-args]
  (println "hello!")
  (library-demo.server-events-demo/start))

(defn ^:dev/before-load stop []
  (js/console.log "before-load hook: stop"))

(defn ^:dev/after-load start []
  (js/console.log "after-load hook: start")
  (main))
