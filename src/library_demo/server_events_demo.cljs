(ns library-demo.server-events-demo
  (:require
    [mount.core :as mount :refer [defstate]]
    [cljs.nodejs :as nodejs]
    [district.server.web3-events :as web3-events :refer [register-callback! unregister-callbacks!]]))

(def process (nodejs/require "process"))

(defn start []
  (println "library-demo.server-events-demo: starting demo"))

(def smart-contracts
  {:ens {:name "ENS" :address "0x00000000000C2E074eC69A0dFb2997BA6C7d2e1e"}})

(-> (mount/with-args
      {:web3 {:url "wss://mainnet.infura.io/ws/v3/fd0074468fd64e36b495c846a26a3f9d"}
       :smart-contracts {:contracts-var #'smart-contracts
                         :print-gas-usage? true
                         :contracts-build-path (str (.cwd process) "/data/")
                         }
       :web3-events {:events {:ens/new-owner [:ens :NewOwner]
                              :ens/transfer [:ens :Transfer] }
                     :block-step 1000
                     :from-block 12958350}})
    (mount/start))
