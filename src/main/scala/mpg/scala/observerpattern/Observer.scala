package mpg.scala.observerpattern

trait Observer {
  def receiveCardUpdate()
  def receiveGameUpdate(boolean: Boolean)

}
