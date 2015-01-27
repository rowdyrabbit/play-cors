package be.cafeba.cors

import org.scalatest.Matchers
import play.api.mvc.Result
import play.api.test.Helpers._

import scala.concurrent.Future

trait HeadersCheckSupport { this: Matchers =>

  /**
   * List of CORS-related headers that this library adds
   */
  val CorsHeaderNames: Seq[String] = Seq(
    "Access-Control-Expose-Headers",
    "Access-Control-Allow-Methods",
    "Access-Control-Allow-Headers",
    "Access-Control-Allow-Origin")

  /**
   * Checks for the presence and non-emptiness of CORS headers
   */
  def checkForCorsHeaders(fR: Future[Result]): Unit = {
    val rHeaders = headers(fR).toMap
    CorsHeaderNames.foreach(n => rHeaders(n) shouldNot be('empty))
  }
}
