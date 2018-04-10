name := "fitmanclient"

version := "1.0"

scalaVersion := "2.12.2"

val finatraVersion  = "18.3.0"

libraryDependencies ++= Seq(
  "com.twitter" %% "finatra-http" % finatraVersion,
  "com.twitter" %% "finatra-httpclient" % finatraVersion,
  "ch.qos.logback" % "logback-classic" % "1.2.3",
)