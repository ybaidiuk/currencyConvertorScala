import EuroConverter._
import Printer._
import akka.actor.{Actor, ActorLogging, ActorRef, Props}

object EuroConverter {
  def props(printerActor: ActorRef): Props = Props(new EuroConverter(printerActor))

  //comandListWithArgs
  case class euro2bitcoin(euro: BigDecimal)
  case class euro2dollar(euro: BigDecimal)
}

class EuroConverter(printerActor: ActorRef) extends Actor with ActorLogging {


  def receive = {
    //    Behavior
    case euro2bitcoin(euro) =>
      printerActor ! PrintCurrency(euro / 5551)

    case euro2dollar(euro) =>
      printerActor ! PrintCurrency(euro * 1.18)
  }
}