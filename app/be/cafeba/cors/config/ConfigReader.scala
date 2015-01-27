package be.cafeba.cors.config

import play.api.Configuration

object ConfigReader {

  /**
   * Returns an [[AccessControl]] for the passed in [[Configuration]]
   */
  def accessControl(config: Configuration): AccessControl =
    AccessControl(
      allowedOrigin = maybeAllowedOrigin(config),
      allowedMethods = allowedMethods(config),
      allowedHeaders = allowedHeaders(config),
      exposedHeaders = exposedHeaders(config)
    )

  /**
   * Returns an Option [[String]] for CORS Allow Origin based on the passed in
   * Play [[Configuration]]
   */
  private def maybeAllowedOrigin(config: Configuration): Option[String] = config.getString("cors.allow_origin")

  /**
   * Returns a [[String]] for CORS Expose Headers based on the passed in
   * Play [[Configuration]]
   *
   * If no config has been set, defaults to "WWW-Authenticate, Server-Authorization"
   */
  private def exposedHeaders(config: Configuration): String = config.getString("cors.expose_headers").getOrElse("WWW-Authenticate, Server-Authorization")

  /**
   * Returns a [[String]] for CORS Allow Methods based on the passed in
   * Play [[Configuration]]
   *
   * If no config has been set, defaults to "POST, GET, OPTIONS, PUT, DELETE"
   */
  private def allowedMethods(config: Configuration): String = config.getString("cors.methods.allowed").getOrElse("POST, GET, OPTIONS, PUT, DELETE")

  /**
   * Returns a [[String]] for CORS Allow Headers based on the passed in
   * Play [[Configuration]]
   *
   * If no config has been set, defaults to "x-requested-with,content-type,Cache-Control,Pragma,Date"
   */
  private def allowedHeaders(config: Configuration): String = config.getString("cors.headers.allowed").getOrElse("x-requested-with,content-type,Cache-Control,Pragma,Date")

}