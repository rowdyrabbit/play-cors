name := "sample-cors"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  "be.cafeba" %% "play-cors" % "1.0-SNAPSHOT"
)
