package io.github.mvillafuertem.future

import java.util.concurrent.ForkJoinPool

import org.slf4j.{Logger, LoggerFactory}
import co.elastic.apm.api.ElasticApm

import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, ExecutionContext, Future}

object Main extends App {

  val _ = ElasticApmAgent.start()

  implicit val executionContext: ExecutionContext =
    ExecutionContext.fromExecutorService(
      new ForkJoinPool(Runtime.getRuntime.availableProcessors)
    )

  val logger: Logger = LoggerFactory.getLogger("Main")

  val program =
    for {
      transaction <- Future(ElasticApm.startTransaction().setName("test-trace"))
      _ <- Future(transaction.activate())
      _ <- Future(logger.info("Starting"))
      _ <- new MultiThreading(executionContext).runMulti(
        () => Future(Thread.sleep(2000)),
        () => Future(Thread.sleep(3000))
      )
      _ <- Future(logger.info("Halfway"))
      _ <- Future(logger.info("Finished"))
      _ <- Future(transaction.end())
    } yield ()

  val program2 =
    for {
      transaction <- Future(ElasticApm.startTransaction().setName("test-trace2"))
      _ <- Future(transaction.activate())
      _ <- Future(logger.info("Starting"))
      _ <- new MultiThreading(executionContext).runMulti(
        () => Future(Thread.sleep(2000)),
        () => Future(Thread.sleep(3000))
      )
      _ <- Future(logger.info("Halfway"))
      _ <- Future(logger.info("Finished"))
      _ <- Future(transaction.end())
    } yield ()

  val program3 =
    for {
      transaction <- Future(ElasticApm.startTransaction().setName("test-trace2"))
      _ <- Future(transaction.activate())
      _ <- Future(logger.info("Starting"))
      _ <- new MultiThreading(executionContext).runMulti(
        () => Future(Thread.sleep(2000)),
        () => Future(Thread.sleep(3000))
      )
      _ <- Future(logger.info("Halfway"))
      _ <- Future(logger.info("Finished"))
      _ <- Future(transaction.end())
    } yield ()

  Await.result(program, 30 seconds)
  Await.result(program2, 30 seconds)
  Await.result(program3, 30 seconds)

}
