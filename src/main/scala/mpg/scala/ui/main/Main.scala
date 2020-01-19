import mpg.scala.controller.board.BoardController
import mpg.scala.model.board.Board
import mpg.scala.model.memorycard.MemoryCard
import mpg.scala.model.player.Player
import mpg.scala.ui.gui.Gui
import mpg.scala.ui.tui.Tui

object Main {

  val playerOne: Player = Player(isActive = true, 0)
  val playerTwo: Player = Player(isActive = false, 0)
  val cards__ : Vector[MemoryCard] = Vector[MemoryCard]()
  var board: Board = Board(cards__)
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
