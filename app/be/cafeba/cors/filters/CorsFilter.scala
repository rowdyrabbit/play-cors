package be.cafeba.cors.filters

import be.cafeba.cors.config.ConfigReader.AccessControl._
import play.api.mvc._

import scala.concurrent.ExecutionContext.Implicits.global


class CorsFilter extends EssentialFilter {
  def apply(next: EssentialAction) = new EssentialAction {
    def apply(requestHeader: RequestHeader) = {
      next(requestHeader).map { result =>
        result.withHeaders(
          getAllowOrigin(requestHeader),
          getAllowHeaders(),
          getAllowMethods(),
          getExposedHeaders())
      }
    }
  }
}


