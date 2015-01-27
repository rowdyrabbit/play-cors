package be.cafeba.cors.controllers

import be.cafeba.cors.HeadersCheckSupport
import org.scalatest._
import org.scalatestplus.play.OneAppPerSuite
import play.api.test.FakeRequest

class CorsControllerSpec extends FunSpec with Matchers with OneAppPerSuite with HeadersCheckSupport {

  describe(".preflight") {

    it("should return a response with CORS headers") {
      val fResult = CorsController.preflight("meh").apply(FakeRequest())
      checkForCorsHeaders(fResult)
    }

  }

}
