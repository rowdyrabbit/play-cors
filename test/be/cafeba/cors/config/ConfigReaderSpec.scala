package be.cafeba.cors.config

import be.cafeba.cors.config.ConfigReader.AccessControl
import org.scalatest._
import org.scalatestplus.play.OneAppPerSuite
import play.api.test.{FakeApplication, FakeRequest}

class ConfigReaderNoCustomSettingsSpec extends FunSpec with Matchers with OneAppPerSuite {

  lazy val subject = new AccessControl

  it("should return the default for Allow Header") {
    subject.allowHeader shouldBe ("Allow" -> "*")
  }

  it("should return the default for Access-Control-Allow-Headers Header") {
    subject.allowHeadersHeader shouldBe ("Access-Control-Allow-Headers" -> "x-requested-with,content-type,Cache-Control,Pragma,Date")
  }

  it("should return the default for Access-Control-Allow-Methods Header") {
    subject.allowMethodsHeader shouldBe ("Access-Control-Allow-Methods" -> "POST, GET, OPTIONS, PUT, DELETE")
  }

  it("should return the default for Access-Control-Expose-Headers") {
    subject.exposedHeadersHeader shouldBe ("Access-Control-Expose-Headers" -> "WWW-Authenticate, Server-Authorization")
  }

  it("should return the default for Access-Control-Allow-Origin") {
    subject.allowOriginHeader(FakeRequest().withHeaders("Host" -> "nowhere.com")) shouldBe ("Access-Control-Allow-Origin" -> "http://nowhere.com")
  }

}

class ConfigReaderWithCustomSettingsSpec extends FunSpec with Matchers with OneAppPerSuite {

  override implicit lazy val app = FakeApplication(additionalConfiguration =
    Map(
      "cors.allow" -> "****",
      "cors.allow_origin" -> "https://google.com",
      "cors.expose_headers" -> "WWW-Authenticate",
      "cors.methods.allowed" -> "PATCH",
      "cors.headers.allowed"-> "x-forwarded-for"
    )
  )

  lazy val subject = new AccessControl

  it("should return the configured setting for Allow Header") {
    subject.allowHeader shouldBe ("Allow" -> "****")
  }

  it("should return the configured setting for Access-Control-Allow-Headers Header") {
    subject.allowHeadersHeader shouldBe ("Access-Control-Allow-Headers" -> "x-forwarded-for")
  }

  it("should return the configured setting for Access-Control-Allow-Methods Header") {
    subject.allowMethodsHeader shouldBe ("Access-Control-Allow-Methods" -> "PATCH")
  }

  it("should return the configured setting for Access-Control-Expose-Headers") {
    subject.exposedHeadersHeader shouldBe ("Access-Control-Expose-Headers" -> "WWW-Authenticate")
  }

  it("should return the configured setting for Access-Control-Allow-Origin") {
    subject.allowOriginHeader(FakeRequest().withHeaders("Host" -> "nowhere.com")) shouldBe ("Access-Control-Allow-Origin" -> "https://google.com")
  }

}
