package mpg.scala.ui.panels

import java.awt.event.ComponentEvent

import mpg.scala.controller.board.BoardController
import mpg.scala.controller.memorycard.MemoryCardController
import mpg.scala.model.memorycard.MemoryCard
import mpg.scala.observerpattern.Observer

import scala.swing.{GridPanel, Label}

class BoardPanel(rows0: Int, cols0: Int, boardController: BoardController) extends GridPanel(rows0, cols0) with Observer {

  boardController.addObserver(this)
  val cards__ : Vector[MemoryCard] = boardController.getCards

  for (n <- cards__) {
    contents += new MemoryCardPanel(this, MemoryCardController(n), boardController)

  }
  var label: Label = new Label {
    text = "0"
  }
  var pointsP1: Label = new Label {
    text = "Player 1: 0"
  }
  var pointsP2: Label = new Label {
    text = "Player 2: 0"
  }
  contents += label
  contents += pointsP1
  contents += pointsP2

  override def receiveCardUpdate(): Unit = {
    println("BOARD receiveCardUpdate")

    boardController.countGameMoveUp
    label.text_=(boardController.getGameMoves + "")

    boardController.compareCards()
  }

  override def receiveGameUpdate(boolean: Boolean): Unit = {
    println("BOARD receiveGameUpdate")

    pointsP1.text_=("Player 1: " + boardController.getPlayerOnePoints)
    pointsP2.text_=("Player 2: " + boardController.getPlayerTwoPoints)


  }
}
