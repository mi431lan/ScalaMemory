package mpg.scala.ui.panels

import mpg.scala.controller.board.BoardController
import mpg.scala.controller.memorycard.MemoryCardController
import mpg.scala.model.memorycard.MemoryCard

import scala.swing.GridPanel
import scala.swing.event.ValueChanged

class BoardPanel(rows0: Int, cols0: Int, boardController: BoardController) extends GridPanel(rows0, cols0) {

  val cards__ : Vector[MemoryCard] = boardController.getCards

  for (n <- cards__) contents += new MemoryCardPanel(MemoryCardController(n), boardController)
  listenTo(this)
  reactions += {
    case valueChanged: ValueChanged =>
      // TODO wenn gamemoves 2 dann alle karten reseten
  }
}
