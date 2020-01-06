package mpg.scala.ui.gui

import java.awt.Color

import javax.swing.JMenuItem
import mpg.scala.controller.board.BoardController
import mpg.scala.model.board.{Board, CardCreator}
import mpg.scala.model.memorycard.MemoryCard
import mpg.scala.model.player.Player
import mpg.scala.ui.panels.BoardPanel

import scala.swing.event.ButtonClicked
import scala.swing.{Button, Dimension, GridPanel, Label, MainFrame}

class Gui extends MainFrame {
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
  var board: Board = _
  reactions += {
    case ButtonClicked(component) if component == buttonEasy =>
      board = Board(CardCreator().createRandomCardSet(12))
      contents = createGame(12)
    case ButtonClicked(component) if component == buttonMedium =>
      board = Board(CardCreator().createRandomCardSet(24))
      contents = createGame(24)
    case ButtonClicked(component) if component == buttonHard =>
      board = Board(CardCreator().createRandomCardSet(36))
      contents = createGame(36)


  }

  def createGame(cards:Int): BoardPanel = {
    val playerOne: Player = Player(isActive = true, 0)
    val playerTwo: Player = Player(isActive = false, 0)
    val boardController = new BoardController(board, playerOne, playerTwo)
    new BoardPanel(cards/4, 6, boardController)
  }

}

object ScalaMemory {
  def main(args: Array[String]) {
    val ui = new Gui
    ui.visible = true
    println("End of main function")
  }
}

