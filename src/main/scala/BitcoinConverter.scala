import BitcoinConverter._
import Printer._
import akka.actor.{Actor, ActorLogging, ActorRef, Props}

object BitcoinConverter {
  def props(printerActor: ActorRef): Props = Props(new BitcoinConverter(printerActor))

  case class bitcoin2euro(bitcoin: BigDecimal)
  case class bitcoin2dollar(bitcoin: BigDecimal)
}

class BitcoinConverter(printer: ActorRef) extends Actor with ActorLogging {
  def receive = {
    case bitcoin2euro(btc) =>
      printer ! PrintCurrency(btc * 5551)

    case bitcoin2dollar(btc) =>
      printer ! PrintCurrency(btc * 6500)

  }

}
