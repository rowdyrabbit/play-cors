package be.cafeba.cors.controllers

import play.api.mvc.Results.EmptyContent
import play.api.mvc._

object CorsController extends Controller {

  import be.cafeba.cors.config.current.AccessControl._

  implicit val context = scala.concurrent.ExecutionContext.Implicits.global

  def preflight(all: String) = Action { implicit request =>
    Ok(EmptyContent()).withHeaders(headers(request):_*)
  }

}
