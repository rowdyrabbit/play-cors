package be.cafeba.cors.config
import play.api.{ Application, Play }
import play.api.mvc.RequestHeader

object ConfigReader {

  /**
   *  Returns a CORS [[AccessControl]] config holder for the current running Play App
   */
  val AccessControl = {
    import play.api.Play.current
    new AccessControl
  }

  private [config] class AccessControl(implicit app: Application) {

    private val maybeConfigAllow = Play.configuration.getString("cors.allow_origin")
    private val exposeHeaders: String = Play.configuration.getString("cors.expose_headers").getOrElse("WWW-Authenticate, Server-Authorization")
    private val allowMethods: String = Play.configuration.getString("cors.methods.allowed").getOrElse("POST, GET, OPTIONS, PUT, DELETE")
    private val allowHeaders: String = Play.configuration.getString("cors.headers.allowed").getOrElse("x-requested-with,content-type,Cache-Control,Pragma,Date")
    private val allow: String = Play.configuration.getString("cors.allow").getOrElse("*")

    def allowOriginHeader(requestHeader: RequestHeader): (String, String) = {
      val protocol = if (requestHeader.secure) "https://" else "http://"
      val origin =  protocol + requestHeader.host
      "Access-Control-Allow-Origin" -> maybeConfigAllow.getOrElse(origin)
    }

    val exposedHeadersHeader: (String, String) = "Access-Control-Expose-Headers" -> exposeHeaders

    val allowMethodsHeader: (String, String) = "Access-Control-Allow-Methods" -> allowMethods

    val allowHeadersHeader: (String, String) = "Access-Control-Allow-Headers" -> allowHeaders

    val allowHeader: (String, String) = "Allow" -> allow

  }
}
