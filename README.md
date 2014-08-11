# CORS Plugin

This plugin adds [CORS](http://en.wikipedia.org/wiki/Cross-origin_resource_sharing) support to Scala Play! framework applications.

# Features

* Provides a pre-flight OPTIONS response for all requests to the application. 
* Provides a Play filter which appends the required CORS headers to every HTTP request.

#### Configurable

Configure any of the HTTP headers you might need. The defaults are:

**Preflight requests:**
```
"Access-Control-Allow-Origin" -> "*",
"Access-Control-Expose-Headers" -> "WWW-Authenticate, Server-Authorization",
"Access-Control-Allow-Methods" -> "POST, GET, OPTIONS, PUT, DELETE",
"Access-Control-Allow-Headers" -> "x-requested-with,content-type,Cache-Control,Pragma,Date")
```

**All other HTTP requests:**
```
"Access-Control-Allow-Origin" -> "*",
"Allow" -> "*",
"Access-Control-Allow-Methods" -> "POST, GET, OPTIONS, PUT, DELETE",
"Access-Control-Allow-Headers" -> "Origin, X-Requested-With, Content-Type, Accept, Referrer, User-Agent"
```


# How to install

add  ```"be.cafeba" %% "play-cors" % "0.1"``` to your dependencies


# Sample

For an example, see the bundled sample app
