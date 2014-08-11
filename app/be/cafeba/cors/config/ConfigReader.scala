package be.cafeba.cors.config


object ConfigReader {

  object AccessControl {

    def getAllowOrigin(): (String, String) = {
      "Access-Control-Allow-Origin" -> "*"
    }

    def getExposedHeaders(): (String, String) = {
      "Access-Control-Expose-Headers" -> "WWW-Authenticate, Server-Authorization"
    }

    def getAllowMethods(): (String, String) = {
      "Access-Control-Allow-Methods" -> "POST, GET, OPTIONS, PUT, DELETE"
    }

    def getAllowHeaders(): (String, String) = {
      "Access-Control-Allow-Headers" -> "x-requested-with,content-type,Cache-Control,Pragma,Date"
    }

    def getAllow(): (String, String) = {
      "Allow" -> "*"
    }
  }

}
