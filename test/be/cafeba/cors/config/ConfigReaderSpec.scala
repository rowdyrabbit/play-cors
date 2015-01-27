package be.cafeba.cors.config

import org.scalatest._
import play.api.Configuration

class ConfigReaderSpec extends FunSpec with Matchers {

  describe(".accessControl") {

    describe("with no CORS-related config") {

      val config = Configuration.from(Map.empty)
      val result = ConfigReader.accessControl(config)

      it("should return an AccessControl with the default Allow Headers value") {
        result.exposedHeaders shouldBe "WWW-Authenticate, Server-Authorization"
      }

      it("should return an AccessControl with the default Access-Control-Allow-Headers value ") {
        result.allowedHeaders shouldBe "x-requested-with,content-type,Cache-Control,Pragma,Date"
      }

      it("should return an AccessControl with the default Access-Control-Allow-Methods value ") {
        result.allowedMethods shouldBe "POST, GET, OPTIONS, PUT, DELETE"
      }

      it("should return an AccessControl with the default Access-Control-Allow-Origin value ") {
        result.allowedOrigin shouldBe None
      }

    }

    describe("with CORS-related config") {

      val config = Configuration.from(
        Map(
          "cors.allow_origin" -> "https://google.com",
          "cors.expose_headers" -> "WWW-Authenticate",
          "cors.methods.allowed" -> "PATCH",
          "cors.headers.allowed"-> "x-forwarded-for"
        )
      )
      val result = ConfigReader.accessControl(config)

      it("should return an AccessControl with the default Allow Headers value") {
        result.exposedHeaders shouldBe "WWW-Authenticate"
      }

      it("should return an AccessControl with the default Access-Control-Allow-Headers value ") {
        result.allowedHeaders shouldBe "x-forwarded-for"
      }

      it("should return an AccessControl with the default Access-Control-Allow-Methods value ") {
        result.allowedMethods shouldBe "PATCH"
      }

      it("should return an AccessControl with the default Access-Control-Allow-Origin value ") {
        result.allowedOrigin shouldBe Some("https://google.com")
      }

    }

  }
}