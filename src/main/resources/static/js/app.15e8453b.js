(function(e){function t(t){for(var n,o,u=t[0],s=t[1],i=t[2],p=0,f=[];p<u.length;p++)o=u[p],Object.prototype.hasOwnProperty.call(a,o)&&a[o]&&f.push(a[o][0]),a[o]=0;for(n in s)Object.prototype.hasOwnProperty.call(s,n)&&(e[n]=s[n]);l&&l(t);while(f.length)f.shift()();return c.push.apply(c,i||[]),r()}function r(){for(var e,t=0;t<c.length;t++){for(var r=c[t],n=!0,u=1;u<r.length;u++){var s=r[u];0!==a[s]&&(n=!1)}n&&(c.splice(t--,1),e=o(o.s=r[0]))}return e}var n={},a={app:0},c=[];function o(t){if(n[t])return n[t].exports;var r=n[t]={i:t,l:!1,exports:{}};return e[t].call(r.exports,r,r.exports,o),r.l=!0,r.exports}o.m=e,o.c=n,o.d=function(e,t,r){o.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:r})},o.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},o.t=function(e,t){if(1&t&&(e=o(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var r=Object.create(null);if(o.r(r),Object.defineProperty(r,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var n in e)o.d(r,n,function(t){return e[t]}.bind(null,n));return r},o.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return o.d(t,"a",t),t},o.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},o.p="/static/";var u=window["webpackJsonp"]=window["webpackJsonp"]||[],s=u.push.bind(u);u.push=t,u=u.slice();for(var i=0;i<u.length;i++)t(u[i]);var l=s;c.push([1,"chunk-vendors"]),r()})({0:function(e,t){},1:function(e,t,r){e.exports=r("56d7")},"56d7":function(e,t,r){"use strict";r.r(t);r("e260"),r("e6cf"),r("cca6"),r("a79d");var n=r("2b0e"),a=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{attrs:{id:"app"}},[r("div",{staticClass:"articles"},[r("h2",[e._v("sora")]),e.soraArray?r("section",{staticClass:"articles-list"},e._l(e.soraArray,(function(t,n){return r("article",{key:n},[r("img",{staticClass:"thumbnail",attrs:{src:t.fields.file.url,alt:""}}),r("div",{staticClass:"article-text"},[r("div",{staticClass:"date"},[e._v(e._s(new Date(t.sys.createdAt).toDateString()))]),r("h4",[e._v(e._s(t.fields.title))]),r("p",[e._v(e._s(t.fields.description))])])])})),0):e._e()])])},c=[],o=(r("b64b"),r("96cf"),r("1da1")),u=r("563c"),s=Object(u["a"])({space:"304ohtpm3kbd",accessToken:"T9VGZ4edHA1uEvSzKqNt-6A_sU3lmHsRP0peghrrp7w"}),i={name:"app",data:function(){return{soras:{},soraArray:[]}},computed:{},created:function(){return Object(o["a"])(regeneratorRuntime.mark((function e(){return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:case"end":return e.stop()}}),e)})))()},mounted:function(){var e=this;return Object(o["a"])(regeneratorRuntime.mark((function t(){var r;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return r=function(){var e=Object(o["a"])(regeneratorRuntime.mark((function e(t){var r,n,a;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:for(r=Object.keys(t),n=[],a=0;a<r.length;a++)n.push(t[r[a]]);return e.abrupt("return",n);case 5:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}(),t.next=3,e.test();case 3:return e.soras=t.sent,t.next=6,r(e.soras);case 6:e.soraArray=t.sent;case 7:case"end":return t.stop()}}),t)})))()},methods:{test:function(){return Object(o["a"])(regeneratorRuntime.mark((function e(){return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,s.getEntry("3Rf3dWrTo0H1yCC8TzUwMk").then((function(e){return e.fields}));case 2:return e.abrupt("return",e.sent);case 3:case"end":return e.stop()}}),e)})))()}}},l=i,p=(r("5c0b"),r("2877")),f=Object(p["a"])(l,a,c,!1,null,null,null),d=f.exports;n["a"].config.productionTip=!1,new n["a"]({render:function(e){return e(d)}}).$mount("#app")},"5c0b":function(e,t,r){"use strict";var n=r("9c0c"),a=r.n(n);a.a},"9c0c":function(e,t,r){}});
//# sourceMappingURL=app.15e8453b.js.map