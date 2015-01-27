package be.cafeba.cors.filters

import be.cafeba.cors.HeadersCheckSupport
import org.scalatest._
import org.scalatestplus.play.OneAppPerSuite
import play.api.mvc.{Results, RequestHeader}
import play.api.mvc.Results.EmptyContent
import play.api.test.FakeRequest

import scala.concurrent.Future

class CorsFilterSpec extends FunSpec with Matchers with Results with OneAppPerSuite with HeadersCheckSupport {

  val fakeAction = { req: RequestHeader => Future.successful(Ok(EmptyContent())) }

  describe(".apply") {

    it("should add CORS headers to a processed request") {
      val fResult = CorsFilter(fakeAction)(FakeRequest())
      checkForCorsHeaders(fResult)
    }

  }

}
