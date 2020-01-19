package mpg.scala.ui.gui

import java.awt.Color

import javax.swing.JMenuItem
import mpg.scala.controller.board.BoardController
import mpg.scala.model.board.{Board, CardCreator}
import mpg.scala.model.memorycard.MemoryCard
import mpg.scala.model.player.Player
import mpg.scala.ui.panels.BoardPanel
import mpg.scala.ui.tui.Tui

import scala.swing.event.ButtonClicked
import scala.swing.{Button, Dimension, GridPanel, Label, MainFrame}

class Gui (boardController:BoardController)extends MainFrame {

  title = "Scala Memory"
  var start: Label = new Label {
    text = "Choose difficulty!"
  }
  val buttonEasy: Button = new Button {
    text = "Easy (12 cards)"
    enabled = true
  }
  val buttonMedium: Button = new Button {
    text = "Medium (24 cards)"
    enabled = true
  }
  val buttonHard: Button = new Button {
    text = "Hard (36 cards)"
    enabled = true
  }
  val gridPanel: GridPanel = new GridPanel(0, 1) {
    contents += start
    contents += buttonEasy
    contents += buttonMedium
    contents += buttonHard

  }
  contents = gridPanel

  listenTo(buttonEasy, buttonMedium, buttonHard)
  reactions += {
    case ButtonClicked(component) if component == buttonEasy =>
      boardController.board = Board(CardCreator().createRandomCardSet(12))
      contents = createGame(12)
    case ButtonClicked(component) if component == buttonMedium =>
      boardController.board = Board(CardCreator().createRandomCardSet(24))
      contents = createGame(24)
    case ButtonClicked(component) if component == buttonHard =>
      boardController.board = Board(CardCreator().createRandomCardSet(36))
      contents = createGame(36)


  }

  def createGame(cards:Int): BoardPanel = {
    boardController.createCardControllers
    new BoardPanel(cards/4, 6, boardController)
  }

}

object ScalaMemory {

  val playerOne: Player = Player(isActive = true, 0)
  val playerTwo: Player = Player(isActive = false, 0)
  val cards__ : Vector[MemoryCard]=Vector[MemoryCard]()
  var board:Board=Board(cards__)
  val boardController = new BoardController(board, playerOne, playerTwo)
  boardController.createCardControllers

  def main(args: Array[String]) {
    val ui = new Gui(boardController)
    ui.visible = true
    val tui = new Tui(boardController)
    tui.startGame()
    println("End of main function")
  }
}

