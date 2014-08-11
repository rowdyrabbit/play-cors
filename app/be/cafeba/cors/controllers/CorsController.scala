package be.cafeba.cors.controllers

import play.api.mvc._


object CorsController extends Controller {

    implicit val context = scala.concurrent.ExecutionContext.Implicits.global

    def preflight(all: String) = Action {
      Ok("").withHeaders("Access-Control-Allow-Origin" -> "*",
        "Allow" -> "*",
        "Access-Control-Allow-Methods" -> "POST, GET, PUT, DELETE, OPTIONS",
        "Access-Control-Allow-Headers" -> "Origin, X-Requested-With, Content-Type, Accept, Referrer, User-Agent");
    }


}
