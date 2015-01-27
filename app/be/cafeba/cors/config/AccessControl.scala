package be.cafeba.cors.config

import play.api.mvc.RequestHeader

/**
 * Holds Access Control config data for CORS
 *
 * See http://www.w3.org/TR/cors
 */
case class AccessControl(allowedOrigin: Option[String], allowedMethods: String, allowedHeaders: String, exposedHeaders: String) {

  /**
   * Returns CORS access control headers for a given request
   */
  def headers(req: RequestHeader): Seq[(String, String)] =
    Seq(
      allowedOriginHeader(req),
      exposedHeadersHeader,
      allowMethodsHeader,
      allowHeadersHeader
    )

  private val exposedHeadersHeader: (String, String) = "Access-Control-Expose-Headers" -> exposedHeaders

  private val allowMethodsHeader: (String, String) = "Access-Control-Allow-Methods" -> allowedMethods

  private val allowHeadersHeader: (String, String) = "Access-Control-Allow-Headers" -> allowedHeaders

  private def allowedOriginHeader(req: RequestHeader): (String, String) = {
    val protocol = if (req.secure) "https://" else "http://"
    val origin =  protocol + req.host
    "Access-Control-Allow-Origin" -> allowedOrigin.getOrElse(origin)
  }

}