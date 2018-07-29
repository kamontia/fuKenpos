name := "Web"

version := "1.0"

lazy val `web` = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/"

scalaVersion := "2.11.11"

libraryDependencies ++= Seq(
  javaJdbc,
  javaWs,
  cache,
  javaJpa,
  "org.hibernate" % "hibernate-entitymanager" % "4.3.9.Final", // replace by your jpa implementation,
  "org.webjars" % "bootstrap" % "3.0.0"
)

unmanagedResourceDirectories in Test <+= baseDirectory(_ / "target/web/public/test")

      