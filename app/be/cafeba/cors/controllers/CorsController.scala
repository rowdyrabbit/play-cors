package be.cafeba.cors.controllers

import play.api.mvc._
import be.cafeba.cors.config.ConfigReader.AccessControl._

object CorsController extends Controller {

    implicit val context = scala.concurrent.ExecutionContext.Implicits.global

    def preflight(all: String) = Action { implicit request =>
      Ok("").withHeaders(
        getAllow(),
        getAllowOrigin(request),
        getAllowMethods(),
        getAllowHeaders())
    }


}
