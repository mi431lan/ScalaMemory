package mpg.scala.ui.panels

import java.awt.Color

import javax.swing.border.LineBorder
import mpg.scala.controller.board.BoardController
import mpg.scala.controller.memorycard.MemoryCardController
import mpg.scala.observerpattern.Observer

import scala.swing.{Color, Panel}
import scala.swing.event.{MouseClicked, MouseReleased}

class MemoryCardPanel(boardPanel: BoardPanel, memoryCardController: MemoryCardController, boardController: BoardController) extends Panel with Observer {

  opaque = true
  background = memoryCardController.getBackSide
  border = LineBorder.createGrayLineBorder()
  memoryCardController.addObserver(this)
  memoryCardController.addObserver(boardPanel)
  boardController.addObserver(this)
  listenTo(mouse.clicks)
  reactions += {
    case e: MouseClicked =>
      println("Mouse clicked at " + e.point)
      boardController.addCard(memoryCardController.getCard)
      memoryCardController.flipCardToFrontSide()
  }

  override def receiveCardUpdate(): Unit = {
    println("CARD receiveCardUpdate")
    background = memoryCardController.getActiveBackground
  }

  override def receiveGameUpdate(boolean: Boolean): Unit = {
    println("CARD receiveGameUpdate")
    if (!boolean && memoryCardController.getCard.state) {
      println("NOT MATCH FLIPPING ALL")
      background = memoryCardController.flipCardToBackSide()
    } else if (boolean && memoryCardController.getCard.state) {
      println("match")
      visible= false
    }
  }
}
