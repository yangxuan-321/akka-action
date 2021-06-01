package org.moda.http

import akka.actor
import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.adapter._
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.Materializer
import com.typesafe.config.{Config, ConfigFactory}
import com.typesafe.scalalogging.Logger
import org.moda.api.Api

import scala.concurrent.Future

object AkkaHttpServer {

  def apply()(implicit system: ActorSystem[_], mat: Materializer) = new AkkaHttpServer()

}

class AkkaHttpServer(implicit system: ActorSystem[_], mat: Materializer) {

  //  implicit val ec: ExecutionContextExecutor = system.toClassic.dispatcher

  private[this] val config: Config = ConfigFactory.load()

  private[this] val logger = Logger(getClass)


  def server(): Future[Http.ServerBinding] = {
    val address         = config.getString("http.akka.host")
    val port            = config.getInt("http.akka.port")
    val apis: List[Api] = List(
    )
//    val routes = apis.map { ax =>
//      ax.publicR ~ auth.authenticate {x => ax.authedR(x)}
//    }.reduceLeft(_ ~ _)
    val routes = apis.filter(_.publicR.nonEmpty).map(_.publicR.get).reduceLeft(_ ~ _)

    implicit val _system: actor.ActorSystem = system.toClassic
    val i = Http().bindAndHandle(routes, address, port)
    val stream = getClass.getResourceAsStream("/issue.txt")
    val text = scala.io.Source.fromInputStream(stream).mkString.replace("akka-action!", s"""Server online at http://$address:$port/ ...""")
    logger.info(text)
    i
  }

}
