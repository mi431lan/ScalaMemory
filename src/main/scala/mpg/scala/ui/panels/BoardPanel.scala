package mpg.scala.ui.panels

import java.awt.{Color, Font}
import java.awt.event.ComponentEvent

import javax.swing.border.Border
import mpg.scala.controller.board.BoardController
import mpg.scala.controller.memorycard.MemoryCardController
import mpg.scala.model.memorycard.MemoryCard
import mpg.scala.observerpattern.Observer

import scala.collection.mutable.ListBuffer
import scala.swing.{GridPanel, Label}

class BoardPanel(rows0: Int, cols0: Int, boardController: BoardController) extends GridPanel(rows0, cols0) with Observer {

  boardController.addObserver(this)

  for (n <- boardController.cardControllers) {
    contents += new MemoryCardPanel(this, n, boardController)
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

  var count = 0;

  override def receiveGameUpdate(boolean: Boolean): Unit = {

    visualizeActivePlayer()
    pointsP1.text_=("Player 1: " + boardController.getPlayerOnePoints)
    pointsP2.text_=("Player 2: " + boardController.getPlayerTwoPoints)
    if (boolean) {

      count = count + 2
    }
    if (count == boardController.getCards.size) {
      contents -= pointsP1
      contents -= pointsP2
      var gameFinish: Label = new Label {

        text = getWinner
        font = new Font("Ariel", java.awt.Font.ITALIC, 18)
      }
      contents += gameFinish
    }

  }

  def getWinner: String = {
    if (boardController.playerOne.points > boardController.playerTwo.points) {
      "Player One has won!!"
    } else
      "Player Two has won!!"
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
