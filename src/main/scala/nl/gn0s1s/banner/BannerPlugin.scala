package nl.gn0s1s.banner

import java.io.File

import io.leego.banana.BananaUtils

import sbt.*
import sbt.Keys.*

object BannerPlugin extends AutoPlugin {
  override def trigger = allRequirements

  object autoImport {
    val bannerGenerate       = taskKey[Seq[File]]("Generate the banner")
    lazy val bannerText      = settingKey[String]("The banner text")
    lazy val bannerCaption   = settingKey[Option[String]]("The banner caption")
    lazy val bannerOverwrite = settingKey[Boolean]("Enable overwriting the banner file")
  }

  import autoImport.*

  override lazy val projectSettings = Seq(
    bannerGenerate  := generateBanner(
      bannerText.value,
      bannerCaption.value,
      bannerOverwrite.value,
      (Compile / resourceDirectory).value / "banner.txt"
    ),
    bannerText      := "placeholder",
    bannerCaption   := None,
    bannerOverwrite := false,
    Compile / resourceGenerators += bannerGenerate.taskValue,
    bannerGenerate  := bannerGenerate.triggeredBy(Compile / compile).value // trick to generate the resource on compile, see https://github.com/sbt/sbt/issues/1832
  )

  private def generateBanner(text: String, caption: Option[String], overwrite: Boolean, file: File): Seq[File] =
    if (text.nonEmpty && (!file.exists || overwrite)) {
      IO.write(file, BananaUtils.bananaify(text)) // FigletFont.convertOneLine(text))
      caption.filter(_.nonEmpty).foreach(c => IO.append(file, s"\n$c"))
      Seq(file)
    } else
      Nil
}
