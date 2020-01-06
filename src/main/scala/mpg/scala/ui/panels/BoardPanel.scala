package mpg.scala.ui.panels

import java.awt.Color
import java.awt.event.ComponentEvent

import javax.swing.border.Border
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

  var pointsP1: Label = new Label {
    text = "Player 1: 0"
  }

  var pointsP2: Label = new Label {
    text = "Player 2: 0"
  }

  contents += pointsP1
  contents += pointsP2
  visualizeActivePlayer()

  override def receiveCardUpdate(): Unit = {

    boardController.compareCards()
  }

  override def receiveGameUpdate(boolean: Boolean): Unit = {

    visualizeActivePlayer()
    pointsP1.text_=("Player 1: " + boardController.getPlayerOnePoints)
    pointsP2.text_=("Player 2: " + boardController.getPlayerTwoPoints)


  }

  def visualizeActivePlayer(): Unit = {

    if (boardController.checkActivePlayer() == 1) {
      pointsP1.foreground = (Color.red)
      pointsP2.foreground = (Color.black)

    } else if (boardController.checkActivePlayer() == 2) {
      pointsP2.foreground = (Color.red)
      pointsP1.foreground = (Color.black)

    }
  }
}
