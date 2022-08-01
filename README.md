## district0x ClojureScript libraries demos

### [district.server.web3-events](https://github.com/district0x/district-server-web3-events)

Fetches the events from ENS contract using `district.server.web3-events`.
ENS contract: https://etherscan.io/address/0x00000000000c2e074ec69a0dfb2997ba6c7d2e1e#code

Contract data under `data/ENS.*` are from _enscontracts_ node module
  - https://github.com/district0x/name-bazaar/blob/b676192b85e7481d8d93627498b963e7b2d7d4fd/project.clj#L84
  - https://www.npmjs.com/package/@ensdomains/ens-contracts/v/0.0.4
To get the files:
  - install the NPM package `yarn add @ensdomains/ens-contracts@0.0.4 --ignore-engines`,
  - find the files under `node_modules/@ensdomains/ens-contracts/build/contracts`

Use:
1. `npx shadow-cljs watch script`
2. `node out/d0x-library-demo.js`

Output:
```
❯ node out/d0x-library-demo.js
hello!
IPFS Instance Started...
<><> IPFS turning into BLOB {:hello "World", :answer 42, :things [1 2 3], :library-demo.cljs-ipfs-http-client-demo/dummy :library-demo.cljs-ipfs-http-client-demo/dummy}
response-add:  [#object[cljs.core.async.impl.channels.ManyToManyChannel] #object[cljs.core.async.impl.channels.ManyToManyChannel]]
(node:83709) ExperimentalWarning: buffer.Blob is an experimental feature. This feature could change at any time
(Use `node --trace-warnings ...` to show where the warning was created)

/home/madis/code/madis/d0x-library-demo/node_modules/delayed-stream/lib/delayed_stream.js:33
  source.on('error', function() {});
         ^
TypeError: source.on is not a function
    at Function.DelayedStream.create (/home/madis/code/madis/d0x-library-demo/node_modules/delayed-stream/lib/delayed_stream.js:33:10)
    at FormData.CombinedStream.append (/home/madis/code/madis/d0x-library-demo/node_modules/combined-stream/lib/combined_stream.js:45:37)
    at FormData.append (/home/madis/code/madis/d0x-library-demo/node_modules/form-data/lib/form_data.js:74:3)
    at appendFormValue (/home/madis/code/madis/d0x-library-demo/node_modules/request/request.js:326:21)
    at Request.init (/home/madis/code/madis/d0x-library-demo/node_modules/request/request.js:337:11)
    at new Request (/home/madis/code/madis/d0x-library-demo/node_modules/request/request.js:127:8)
    at request (/home/madis/code/madis/d0x-library-demo/node_modules/request/index.js:53:10)
    at Function.post (/home/madis/code/madis/d0x-library-demo/node_modules/request/index.js:61:12)
    at cljs_ipfs_api$utils$node_http_call (/home/madis/code/madis/d0x-library-demo/.shadow-cljs/builds/script/dev/out/cljs-runtime/cljs_ipfs_api/utils.cljs:129:15)
    at Object.cljs_ipfs_api$utils$api_call [as api_call] (/home/madis/code/madis/d0x-library-demo/.shadow-cljs/builds/script/dev/out/cljs-runtime/cljs_ipfs_api/utils.cljs:139:4)
```

The same code for REPL use:

```clojure
(shadow/repl :script)
(require '[cljs.core.async :as async])
(def response-add (atom nil))
(def result-add (atom :not-yet))
; add-edn! succeeds but doesn't return correct value, and so errors on reset!
; Hash: Qmbxjj8N6R6pw382Nd1VfaKSkV386x1zqWpghpzaPihxRF
(reset! response-add (add-edn! {:hello "World" :answer 42 :things [1 2 3]}))
@response-add
(go (async/take! (first @response-add) #(reset! result-add %)))
@result-add
(go (async/take! (second @response-add) #(reset! result-add %)))
@result-add
```
