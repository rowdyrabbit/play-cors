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


# License

The MIT License (MIT)

Copyright (c) 2014 Denise Fernandez

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
