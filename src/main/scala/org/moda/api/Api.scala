package org.moda.api

import akka.http.scaladsl.server.Route

/**
 * @author moda-master
 * @date 2020/9/4 下午4:32
 */
trait Api {
  def publicR: Option[Route] = None
}
