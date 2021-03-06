package io.github.mvillafuertem.future

import cats.instances.future._
import cats.syntax.flatMap._
import cats.syntax.functor._
import org.slf4j.{ Logger, LoggerFactory }
import scala.concurrent.duration._
import scala.concurrent.{ExecutionContext, Future}
import scala.util.Random

class MultiThreading(executionContext: ExecutionContext) {

  implicit val ec: ExecutionContext = executionContext

  val logger: Logger = LoggerFactory.getLogger(classOf[MultiThreading])

  def runMulti(
    toRunF1: () => Future[Unit],
    toRunF2: () => Future[Unit]
  ): Future[Unit] =
    Future
      .traverse(1 to 5) { _ =>
        val f1 = toRunF1().flatTap(_ => Future(logger.info("runF1")))
        val f2 = toRunF2().flatTap(_ => Future(logger.info("runF2")))
        val f3 =
          Future(Thread.sleep(Random.between(1000, 3000).millis.toMillis)).flatTap(_ => Future(logger.info("sleeping")))
        val f4 = keepBusy.flatTap(_ => Future(logger.info("keeping busy")))

        Future.sequence(List(f1, f2, f3, f4)).void
      }
      .void

  private def keepBusy: Future[Unit] = Future((1 to 10000).foreach(i => s"$i"))

}
