ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.0"

lazy val root = (project in file("."))
  .settings(
    name := "adventofcode2021",
    idePackagePrefix := Some("nl.wwbakker.aoc2021")
  )

libraryDependencies += ("com.github.pathikrit" %% "better-files" % "3.9.1").cross(CrossVersion.for3Use2_13)
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.7"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.9" % "test"
libraryDependencies += "org.scalatest" %% "scalatest-funspec" % "3.2.9" % "test"