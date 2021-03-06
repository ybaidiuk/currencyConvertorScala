import DollarConverter._
import Printer._
import akka.actor.{Actor, ActorLogging, ActorRef, Props}


object DollarConverter {
  def props(printerActor: ActorRef): Props = Props(new DollarConverter(printerActor))

  case class dollar2bitcoin(dollar: BigDecimal)
  case class dollar2euro(dollar: BigDecimal)
}


class DollarConverter(printerActor: ActorRef) extends Actor with ActorLogging {
  def receive = {

    case dollar2bitcoin(dollar) =>
      printerActor ! PrintCurrency(dollar / 6500)

    case dollar2euro(dollar) =>
      printerActor ! PrintCurrency(dollar * 0.85)
  }

}

