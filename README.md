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
library-demo.server-events-demo: starting demo
shadow-cljs - #3 ready!
INFO [district.server.web3-events:29] - web3-events checkpoint file disabled
DEBUG [district.server.smart-contracts:264] - Processing chunk of blocks {:contract :ens, :event :NewOwner, :from 900, :to 900}
DEBUG [district.server.smart-contracts:264] - Processing chunk of blocks {:contract :ens, :event :NewOwner, :from 901, :to 901}
DEBUG [district.server.smart-contracts:264] - Processing chunk of blocks {:contract :ens, :event :NewOwner, :from 902, :to 902}
DEBUG [district.server.smart-contracts:264] - Processing chunk of blocks {:contract :ens, :event :NewOwner, :from 903, :to 903}
<...rest of output omitted...>
```

