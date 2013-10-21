import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "Baker-McKenzie"
  val appVersion      = "1.0"

  val appDependencies = Seq(
    // Add your project dependencies here,
    jdbc,
    "mysql" % "mysql-connector-java" % "5.1.21",
    "org.apache.poi" % "poi" % "3.9",
    "org.apache.poi" % "poi-ooxml" % "3.9"
  )

  val main = play.Project(
    appName, appVersion, appDependencies
  ).settings(
    // Add your own project settings here      
  )

}