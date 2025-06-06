name         := "sbt-banner"
organization := "nl.gn0s1s"
startYear    := Some(2025)
homepage     := Some(url("https://github.com/philippus/sbt-banner"))
licenses += ("MPL-2.0", url("https://www.mozilla.org/MPL/2.0/"))
developers   := List(
  Developer(
    id = "philippus",
    name = "Philippus Baalman",
    email = "",
    url = url("https://github.com/philippus")
  )
)

enablePlugins(SbtPlugin)

libraryDependencies += "com.github.sbt" % "junit-interface" % "0.13.3" % Test

scalaVersion := "2.12.20"
crossScalaVersions += "3.7.1"

pluginCrossBuild / sbtVersion := {
  scalaBinaryVersion.value match {
    case "2.12" => "1.10.7"
    case _      => "2.0.0-M4"
  }
}

Compile / packageBin / packageOptions += Package.ManifestAttributes(
  "Automatic-Module-Name" -> "nl.gn0s1s.banner"
)

scriptedLaunchOpts := {
  scriptedLaunchOpts.value ++ Seq("-Xmx1024M", "-Dplugin.version=" + version.value)
}

scriptedBufferLog := false
