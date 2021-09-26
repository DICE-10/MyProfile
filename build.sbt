name := "PlayTest"
 
version := "1.0" 
      
lazy val `playtest` = (project in file(".")).enablePlugins(PlayScala,PlayJava/*,PlayEbean*/)

resolvers += "Akka Snapshot Repository" at "https://repo.akka.io/snapshots/"
resolvers += Resolver.bintrayRepo("playframework", "maven")
resolvers += Resolver.bintrayRepo("playframework", "sbt-plugin-releases")
      
scalaVersion := "2.13.6"

libraryDependencies ++= Seq(
  jdbc ,
  ehcache ,
  ws ,
  specs2 % Test ,
  guice ,
  "com.typesafe.slick" %% "slick" % "3.3.3",
  "mysql" % "mysql-connector-java" % "8.0.26",
  "org.playframework.anorm" %% "anorm" % "2.6.10",
  "javax.xml.bind" % "jaxb-api" % "2.3.1",
  "javax.activation" % "activation" % "1.1.1",
  "org.glassfish.jaxb" % "jaxb-runtime" % "3.0.2",
  "io.ebean" % "ebean" % "12.11.4")
