package mpg.scala.model.board

import java.awt.Color

import mpg.scala.model.memorycard.MemoryCard

case class CardCreator() {

  var cards: Vector[MemoryCard] = Vector[MemoryCard]()

  var colors:

  def createCardSet(size: Int): Vector[MemoryCard] = {

    for (i <- 1 to size) {
      cards :+ MemoryCard(Color.BLACK, Color.YELLOW, state = false)
    }
    cards
  }


}
