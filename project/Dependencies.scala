import sbt._

/**
 * @author Miguel Villafuerte
 */
object Dependencies {

  val future: Seq[ModuleID] = {
  // M O D U L E
    Seq(
      Artifact.cats,
      Artifact.catsEffect
    ).map(_ % Version.cats) ++ Seq(
      Artifact.elasticApmApi,
      Artifact.elasticApmAttach,
      Artifact.elasticApmOpenTracing
    ).map(_ % Version.elasticApm )++ Seq(
      Artifact.zio % Version.zio,
      Artifact.logback % Version.logback
    ) ++ Seq(
      // M O D U L E  T E S T
      Artifact.zioTest % Version.zio,
      Artifact.zioTestSbt % Version.zio,
      Artifact.scalaTest % Version.scalaTest
    ).map(_ % Test)
  }

  val docs: Seq[ModuleID] =
  // D O C S
    Seq(
    ) ++ Seq(
      // D O C S  T E S T
      Artifact.scalaTest % Version.scalaTest
    ).map(_ % Test)

  private object Artifact {
    val cats = "org.typelevel" %% "cats-core"
    val catsEffect = "org.typelevel" %% "cats-effect"
    val elasticApmAttach ="co.elastic.apm" % "apm-agent-attach"
    val elasticApmApi ="co.elastic.apm" % "apm-agent-api"
    val elasticApmOpenTracing ="co.elastic.apm" % "apm-opentracing"
    val elasticApm = "co.elastic.apm" % "elastic-apm-agent"
    val logback = "ch.qos.logback" % "logback-classic"
    val scalaTest = "org.scalatest" %% "scalatest"
    val zio = "dev.zio" %% "zio"
    val zioTest = "dev.zio" %% "zio-test"
    val zioTestSbt = "dev.zio" %% "zio-test-sbt"
  }

  private object Version {
    val cats = "2.1.0"
    val elasticApm = "1.18.0"
    val logback = "1.2.3"
    val scalaTest = "3.2.2"
    val zio = "1.0.1"
  }

}

