import akka.actor.{Actor, ActorLogging, Props}

object Printer {
  def props: Props = Props[Printer]

  case class PrintCurrency(currency: BigDecimal)
  case class Print(message: String)
}

class Printer extends Actor with ActorLogging {

  import Printer._

  def receive = {
    case PrintCurrency
      (currency: BigDecimal) => println(s"$currency")
    case Print
      (message: String) => println(s"$message")
  }
}

