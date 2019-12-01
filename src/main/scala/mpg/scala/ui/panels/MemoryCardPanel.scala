package mpg.scala.ui.panels

import javax.swing.border.LineBorder
import mpg.scala.controller.board.BoardController
import mpg.scala.controller.memorycard.MemoryCardController

import scala.swing.{Color, Panel}
import scala.swing.event.MouseClicked

class MemoryCardPanel(memoryCardController: MemoryCardController, boardController: BoardController) extends Panel {

  opaque = true
  background = memoryCardController.getBackSide
  border = LineBorder.createGrayLineBorder()
  listenTo(mouse.clicks)
  reactions += {
    case e: MouseClicked =>
      println("Mouse clicked at " + e.point)
      background = memoryCardController.flipCardToFrontSide()
      boardController.countGameMoveUp
      println("Game move: " + boardController.getGameMoves)
      if(boardController.checkGameStatus){
        background=memoryCardController.getActiveBackground
      }


  }

  def updateBackground(): Color = {
    background=memoryCardController.getActiveBackground
    background
  }

}
