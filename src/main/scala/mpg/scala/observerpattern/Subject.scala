package mpg.scala.observerpattern

trait Subject {
  private var observers: List[Observer] = Nil

  def notifyObserversCardUpdate() {
    for (observer <- observers)
      observer.receiveCardUpdate()
  }
  def notifyObserversGameUpdate(boolean:Boolean) {
    for (observer <- observers)
      observer.receiveGameUpdate(boolean)
  }
  def removeObserver(observer: Observer): Unit= observers = observers diff List(observer)
  def addObserver(observer: Observer): Unit = observers = observer :: observers

}
