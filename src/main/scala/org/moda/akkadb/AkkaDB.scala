package org.moda.akkadb

import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors
import com.typesafe.scalalogging.Logger

import scala.collection.mutable

object AkkaDB {

  val map = new mutable.HashMap[String, Object]
  val logger: Logger = Logger(getClass)

  def apply(): Behavior[SetRequest] =
    Behaviors.setup { context =>
      // 接受到 消息 的具体处理
      Behaviors.receiveMessage {
        case SetRequest(k, v) =>
          Thread.sleep(3000)
          logger.info("received SetRequest - key: {} value: {}", k, v)
          map.put(k, v)
          Behaviors.same
        case x =>
          logger.info("received unknown message: {}", x)
          Behaviors.same
      }
    }
}

case class SetRequest(key: String, value: Object)
