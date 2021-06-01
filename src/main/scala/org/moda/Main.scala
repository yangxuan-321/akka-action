package org.moda

import java.util.UUID

import akka.actor.typed.SpawnProtocol.Command
import akka.actor.typed._
import akka.http.scaladsl.Http
import com.typesafe.scalalogging.Logger
import org.moda.http.AkkaHttpServer
import pureconfig.ConfigSource

import scala.concurrent.duration._
import scala.concurrent.{Await, Future}


//object Main extends App {
//
//  import scala.concurrent.ExecutionContext.Implicits.global
//
//  val logger: Logger = Logger(getClass)
//
//  val systemId: String                      = ConfigSource.default.at("akka.system.name").loadOrThrow[String]
//  val selfUuid: String                      = UUID.randomUUID().toString
//  implicit val system: ActorSystem[Command] = ActorSystem(SpawnProtocol(), systemId)
//
//  val bindingFuture: Future[Http.ServerBinding] = AkkaHttpServer().server()
//
//  sys.addShutdownHook {
//    bindingFuture.flatMap(_.unbind()).onComplete { _ =>
//      logger.info("System Terminated. Goodbye.")
//    }
//  }
//
//  Await.result(system.whenTerminated, Duration.Inf)
//}
