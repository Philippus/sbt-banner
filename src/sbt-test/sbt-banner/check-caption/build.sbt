scalaVersion := "2.13.15"

bannerText := "a"
bannerCaption := Some("Powered by sbt-banner")
bannerOverwrite := true

import sbt._

TaskKey[Unit]("check") := {
  val file = (Compile / resourceDirectory).value / "banner.txt"
  if (file.get().map(_.length()).sum <= 55L)
    sys.error(s"caption was not written, file size: ${file.get().map(_.length()).sum.toString}")
}
