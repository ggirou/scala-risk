package controllers

import play.api.mvc._
import play.api.libs.json._
import play.api.Play.current
import akka.actor._

object Application extends Controller {
  def socket = WebSocket.acceptWithActor[JsValue, JsValue] { request =>
    out =>
      MyWebSocketActor.props(out)
  }
}

object MyWebSocketActor {
  def props(out: ActorRef) = Props(new MyWebSocketActor(out))
}

class MyWebSocketActor(out: ActorRef) extends Actor {
  def receive = {
    case msg: JsValue =>
      out ! Json.toJson(Map("I received your message" -> msg))
  }
}