ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.18"

lazy val root = (project in file("."))
  .settings(
    name := "sandbox",

    idePackagePrefix := Some("org.uncertainty.sandbox"),

    resolvers ++= Seq(
      "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
    ),

    addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.15.0"),

    libraryDependencies ++= Seq(
      "org.apache.spark" % "spark-sql_2.12" % "3.5.7" % "provided",
      "org.apache.logging.log4j" % "log4j-core" % "2.25.3"

    )
  )
