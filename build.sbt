ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.18"

lazy val root = (project in file("."))
  .settings(
    name := "sandbox",

    idePackagePrefix := Some("org.uncertainty.sandbox"),

    resolvers ++= Seq(
      "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
    ),

    libraryDependencies ++= Seq(
      "org.apache.spark" % "spark-sql_2.12" % "3.5.7" % "provided",
      "org.apache.logging.log4j" % "log4j-api" % "2.25.3",
      "org.apache.hadoop" % "hadoop-aws" % "3.4.2" % "provided",
      "software.amazon.awssdk" % "sso" % "2.41.20" % "provided",
      "software.amazon.awssdk" % "s3" % "2.41.20" % "provided",
      "software.amazon.awssdk" % "auth" % "2.41.20" % "provided",
      "software.amazon.awssdk" % "ssooidc" % "2.41.20" % "provided",
      "software.amazon.awssdk" % "apache-client" % "2.41.20" % "provided"
    )
  )
