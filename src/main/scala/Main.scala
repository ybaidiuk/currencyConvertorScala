import BitcoinConverter._
import DollarConverter.{dollar2bitcoin, dollar2euro}
import akka.actor.{ActorRef, ActorSystem}

object Main extends App {

  import EuroConverter._

  val system: ActorSystem = ActorSystem("mainAkka")

  val printer: ActorRef = system.actorOf(Printer.props, "printerActor")
  val bitConv: ActorRef = system.actorOf(BitcoinConverter.props(printer), "bitcoinConverter")
  val dollarConv: ActorRef = system.actorOf(DollarConverter.props(printer), "dollarConverter")
  val euroConv: ActorRef = system.actorOf(EuroConverter.props(printer), "euroConverter")

  val euro = BigDecimal(300)
  val dollar = BigDecimal(200)
  val bitcoin = BigDecimal(1)

  //Bitcoin
  bitConv ! bitcoin2dollar(bitcoin)
  bitConv ! bitcoin2euro(bitcoin)

  //Dollar
  dollarConv ! dollar2euro(dollar)
  dollarConv ! dollar2bitcoin(dollar)

  //Euro
  euroConv ! euro2dollar(euro)
  euroConv ! euro2bitcoin(euro)


}