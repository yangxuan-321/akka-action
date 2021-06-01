package org.moda.akkadb

import akka.actor.typed.ActorSystem
import org.scalatest.{FunSpecLike, Matchers}

object DBMain extends App with FunSpecLike with Matchers{
  implicit val system: ActorSystem[SetRequest] = ActorSystem(AkkaDB(), "AkkaDB-System")
  system ! SetRequest("name", "yangxuan")
  Thread.sleep(2000)
  AkkaDB.map.get("name") should equal(Some("yangxuan"))
}
