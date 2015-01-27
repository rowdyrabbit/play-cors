package be.cafeba.cors.filters

import play.api.mvc._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
 * Filter that adds CORS headers to every request
 */
object CorsFilter extends Filter {

  import be.cafeba.cors.config.current.AccessControl._

  def apply(nextFilter: RequestHeader => Future[Result])(requestHeader: RequestHeader): Future[Result] = {
    nextFilter(requestHeader).map { result =>
      result.withHeaders(headers(requestHeader): _*)
    }
  }

}