scalaVersion := "2.13.15"

bannerText := "test"

import sbt._

TaskKey[Unit]("check") := {
  val file = (Compile / resourceDirectory).value / "banner.txt"
  if (!file.exists)
    sys.error("expected banner to be generated")
}
