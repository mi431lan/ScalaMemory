package mpg.scala.ui.gui

import java.awt.Color

import javax.swing.JMenuItem
import mpg.scala.controller.board.BoardController
import mpg.scala.model.board.Board
import mpg.scala.model.memorycard.MemoryCard
import mpg.scala.model.player.Player
import mpg.scala.ui.panels.BoardPanel

import scala.swing.{Dimension, Label, MainFrame}

class Gui extends MainFrame {
  title = "Scala Memory"
  preferredSize = new Dimension(900, 900)

  val label: Label = new Label {
    text = "The button hasn't been clicked yet"
  }
  //TODO builder für karten set
  //TODO zufallsgenerator für kartenposition
  val vector: Vector[MemoryCard] = Vector(MemoryCard(Color.BLACK, Color.YELLOW, state = false),
    MemoryCard(Color.BLACK, Color.YELLOW, state = false),
    MemoryCard(Color.BLACK, Color.BLUE, state = false),
    MemoryCard(Color.BLACK, Color.BLUE, state = false),MemoryCard(Color.BLACK, Color.YELLOW, state = false),
    MemoryCard(Color.BLACK, Color.YELLOW, state = false),
    MemoryCard(Color.BLACK, Color.BLUE, state = false),
    MemoryCard(Color.BLACK, Color.BLUE, state = false))

  val board = new Board(vector,0)
  val playerOne: Player = Player(isActive = true, 0)
  val playerTwo: Player = Player(isActive = false, 0)
  val boardController = new BoardController(board,playerOne,playerTwo)
  title = "Grid Panel"
  contents = new BoardPanel(0, 2, boardController)

  /*new GridPanel(0, 2) {
    contents += card1

    contents += Button("Close") {
      sys.exit(0)
    }
  }*/
}

object ScalaMemory {
  def main(args: Array[String]) {
    val ui = new Gui
    ui.visible = true
    println("End of main function")
  }
}

//http://otfried.org/scala/tictactoe.html
// tui und ui bauen muss beides event basiert sein
// statt arrays vektoren verwenden da immutable
// datenstruktur sollte immutable sein
// klassen mit konstruktor, statt state zu verändern kann neue kopie erstellt werden, änderungen können über den konstruktor an die kopie übergeben werden
