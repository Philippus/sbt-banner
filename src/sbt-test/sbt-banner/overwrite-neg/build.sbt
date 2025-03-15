scalaVersion := "2.13.15"

bannerText      := "a"
bannerOverwrite := false

import sbt._

TaskKey[Unit]("check") := {
  val file = (Compile / resourceDirectory).value / "banner.txt"
  if (file.get().map(_.length()).sum > 55L)
    sys.error(s"file was overwritten, file size: ${file.get().map(_.length()).sum.toString}")
}
