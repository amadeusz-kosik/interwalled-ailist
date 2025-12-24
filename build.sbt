ThisBuild / scalaVersion := "2.13.18"
ThisBuild / organization := "me.kosik.interwalled"

Compile / javacOptions ++= Seq("--release", "17")
Compile / scalacOptions += "-target:17"

val aiList = (project in file("ailist"))
  .settings(name := "ailist")

val benchmark = (project in file("benchmark"))
  .settings(name := "ailist-benchmark")
  .dependsOn(aiList)

val root = (project in file("."))
  .settings(name := "ailist-project")
  .aggregate(aiList)


aiList / releaseVersionFile  := file("version.sbt")
aiList / libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.19" % Test

// SBT Release
import ReleaseTransformations._

aiList / releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runClean,
  runTest,
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  setNextVersion,
  commitNextVersion,
  pushChanges
)
