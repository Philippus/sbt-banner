# sbt-banner

[![build](https://github.com/Philippus/sbt-banner/workflows/build/badge.svg)](https://github.com/Philippus/sbt-banner/actions/workflows/scala.yml?query=workflow%3Abuild+branch%3Amain)
![Current Version](https://img.shields.io/badge/version-0.0.1-brightgreen.svg?style=flat "0.0.1")
[![Scala Steward badge](https://img.shields.io/badge/Scala_Steward-helping-blue.svg?style=flat&logo=data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA4AAAAQCAMAAAARSr4IAAAAVFBMVEUAAACHjojlOy5NWlrKzcYRKjGFjIbp293YycuLa3pYY2LSqql4f3pCUFTgSjNodYRmcXUsPD/NTTbjRS+2jomhgnzNc223cGvZS0HaSD0XLjbaSjElhIr+AAAAAXRSTlMAQObYZgAAAHlJREFUCNdNyosOwyAIhWHAQS1Vt7a77/3fcxxdmv0xwmckutAR1nkm4ggbyEcg/wWmlGLDAA3oL50xi6fk5ffZ3E2E3QfZDCcCN2YtbEWZt+Drc6u6rlqv7Uk0LdKqqr5rk2UCRXOk0vmQKGfc94nOJyQjouF9H/wCc9gECEYfONoAAAAASUVORK5CYII=)](https://scala-steward.org)
[![license](https://img.shields.io/badge/license-MPL%202.0-blue.svg?style=flat "MPL 2.0")](LICENSE)

Inspired by the banner in Spring Boot, sbt-banner can generate a banner in the resources directory on compile, or with
the `bannerGenerate` command. You can, for example add this banner to the log at the start of your application with
something like this:

```scala
Using.resource(Source.fromResource("banner.txt")) { source =>
  logger.info(source.getLines().mkString("\n"))
}
```

## Installation

sbt-banner is published for sbt 1.10.7 and above. To start using it add the following to your plugins.sbt:

```sbt
addSbtPlugin("nl.gn0s1s" % "sbt-banner" % "0.0.1")
```

## Usage

### Tasks

| Task           | Description         | Command                    |
|:---------------|:--------------------|:---------------------------|
| bannerGenerate | Generates a banner. | ```$ sbt bannerGenerate``` |

### Configuration

You can configure the configuration in your `build.sbt` file.

| Setting         | Description                        | Default Value |
|:----------------|:-----------------------------------|:--------------|
| bannerText      | The banner text                    | placeholder   |
| bannerCaption   | The banner caption                 | None          |
| bannerOverwrite | Enable overwriting the banner file | false         |

### Example

```sbt
bannerText := "sbt-banner"
bannerCaption := Some("Powered by 🍌Banana")
```

```
scala> scala.util.Using.resource(scala.io.Source.fromResource("banner.txt")) { source => println(source.getLines().mkString("\n"))}
       _     _        _                                 
   ___| |__ | |_     | |__   __ _ _ __  _ __   ___ _ __ 
  / __| '_ \| __|____| '_ \ / _` | '_ \| '_ \ / _ \ '__|
  \__ \ |_) | ||_____| |_) | (_| | | | | | | |  __/ |   
  |___/_.__/ \__|    |_.__/ \__,_|_| |_|_| |_|\___|_|   
                                                        
 Powered by 🍌Banana

```

## Resources

- [Banana](https://github.com/yihleego/banana)

## License

The code is available under the [Mozilla Public License, version 2.0](LICENSE).
