package mpg.scala.ui.panels

import java.util.{Timer, TimerTask}
import javax.swing.border.LineBorder
import mpg.scala.controller.board.BoardController
import mpg.scala.controller.memorycard.MemoryCardController
import mpg.scala.observerpattern.Observer

import scala.swing.{Dimension, Panel}
import scala.swing.event.{MouseClicked}

class MemoryCardPanel(boardPanel: BoardPanel, memoryCardController: MemoryCardController, boardController: BoardController) extends Panel with Observer {

  preferredSize = new Dimension(200, 200)
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
    background = memoryCardController.getActiveBackground
  }

  override def receiveGameUpdate(boolean: Boolean): Unit = {
    if (!boolean && memoryCardController.getCard.state) {
      background = memoryCardController.getActiveBackground

      new Timer().schedule(new TimerTask() {
        override def run(): Unit = {
          background = memoryCardController.flipCardToBackSide()
        }
      }, 500)


    } else if (boolean && memoryCardController.getCard.state) {
      visible = false
    }
  }
}
