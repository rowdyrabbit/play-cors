package be.cafeba.cors.config

import org.scalatest._
import play.api.test.FakeRequest

class AccessControlSpec extends FunSpec with Matchers {

  val subject = AccessControl(
    allowedOrigin = Some("hello"),
    allowedMethods = "METHOD1,METHOD2",
    allowedHeaders = "x-requested-with",
    exposedHeaders = "AUTH")

  describe("#headers(request) headers") {

    val result = subject.headers(FakeRequest()).toMap

    it("should include Access-Control-Expose-Headers") {
      result("Access-Control-Expose-Headers") shouldBe "AUTH"
    }

    it("should include Access-Control-Allow-Methods") {
      result("Access-Control-Allow-Methods") shouldBe "METHOD1,METHOD2"
    }

    it("should include AAccess-Control-Allow-Headers") {
      result("Access-Control-Allow-Headers") shouldBe "x-requested-with"
    }

    it("should include Access-Control-Allow-Origin") {
      result("Access-Control-Allow-Origin") shouldBe "hello"
    }

  }

}
