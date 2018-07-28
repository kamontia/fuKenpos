name := "Web"
 
version := "1.0" 
      
lazy val `web` = (project in file(".")).enablePlugins(PlayJava,PlayEbean)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/"
      
scalaVersion := "2.11.11"

libraryDependencies ++= Seq( javaJdbc  , javaWs )

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  

      