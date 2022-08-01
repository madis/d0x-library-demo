(ns library-demo.core
  (:require
    ; [library-demo.server-events-demo]
    [library-demo.ipfs.demo]
    ))

(defn main [& cli-args]
  ; (library-demo.server-events-demo/start)
  (library-demo.ipfs.demo/run-demo))

(defn ^:dev/before-load stop []
  (js/console.log "before-load hook: stop"))

(defn ^:dev/after-load start []
  (js/console.log "after-load hook: start")
  (main))
