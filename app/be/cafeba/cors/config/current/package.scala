package be.cafeba.cors.config

import play.api.Play

/**
 * Holds the [[AccessControl]] for the current running Play App
 *
 * Will throw a System Error if addressed when there is no running Play App
 */
package object current {

  import Play.current

  /**
   * Returns an [[be.cafeba.cors.config.AccessControl]] for the current running Play Application.
   */
  val AccessControl: AccessControl = ConfigReader.accessControl(Play.configuration)

}
