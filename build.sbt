name := "risk"

version := "1.0"

scalaVersion := "2.11.1"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
 
//libraryDependencies += "io.backchat.hookup" %% "hookup" % "0.2.2"

//libraryDependencies +=
//  "com.typesafe.akka" %% "akka-actor" % "2.3.4"
  
lazy val root = (project in file(".")).enablePlugins(PlayScala)
