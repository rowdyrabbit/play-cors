name := "play-cors"

organization := "be.cafeba"

version := "1.1-SNAPSHOT"

scalaVersion := "2.11.5"

crossScalaVersions := Seq("2.11.5", "2.10.4")

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { x => false }

pomExtra := (
  <url>https://github.com/rowdyrabbit/play-cors</url>
  <licenses>
    <license>
      <name>MIT License</name>
      <url>http://opensource.org/licenses/MIT</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
   <url>git@github.com:rowdyrabbit/play-cors.git</url>
    <connection>scm:git:git@github.com:rowdyrabbit/play-cors.git</connection>
  </scm>
  <developers>
    <developer>
      <id>rowdyrabbit</id>
      <name>Denise Fernandez</name>
      <url>http://cafeba.be</url>
    </developer>
  </developers>
  )

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play" % "2.3.7" % "provided",
  "com.typesafe.play" %% "play-test" % "2.3.7" % "test",
  "org.scalatestplus" %% "play" % "1.2.0" % Test,
  "org.scalatest" %% "scalatest"  % "2.2.3" % "test"
)


parallelExecution in Test := false

testOptions += Tests.Argument(TestFrameworks.JUnit, "-q", "-v")

publishTo <<= (version) { version: String =>
  val nexus = "https://oss.sonatype.org/"
  if (version.trim.endsWith("SNAPSHOT")) Some("snapshots" at nexus + "content/repositories/snapshots")
  else                                   Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

javacOptions ++= Seq("-source", "1.6", "-target", "1.6", "-Xlint:unchecked", "-encoding", "UTF-8")

scalacOptions += "-deprecation"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

lazy val sample = (project in file("sample/sample-cors"))
  .enablePlugins(PlayScala)
  .settings(
    Keys.fork in Test := false
  ).dependsOn(root).aggregate(root)

