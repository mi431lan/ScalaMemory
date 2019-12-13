package mpg.scala.ui.tui

import java.awt.Color

import javax.swing.JMenuItem
import mpg.scala.controller.board.BoardController
import mpg.scala.controller.memorycard.MemoryCardController
import mpg.scala.model.board.Board
import mpg.scala.model.memorycard.MemoryCard
import mpg.scala.model.player.Player
import mpg.scala.observerpattern.{Observer, Subject}
import mpg.scala.ui.panels.{BoardPanel, MemoryCardPanel}

import scala.io.StdIn
import scala.swing.{Dimension, Label, MainFrame}

class Tui extends Observer {
  var cards: Vector[MemoryCard] = Vector(MemoryCard(Color.BLACK, Color.YELLOW, state = false),
    MemoryCard(Color.BLACK, Color.YELLOW, state = false),
    MemoryCard(Color.BLACK, Color.BLUE, state = false),
    MemoryCard(Color.BLACK, Color.BLUE, state = false))

  val board = new Board(cards, 0)
  val playerOne: Player = Player(isActive = true, 0)
  val playerTwo: Player = Player(isActive = false, 0)

  val boardController = new BoardController(board, playerOne, playerTwo)
  boardController.addObserver(this)

  def startGame(): Unit = {
    println("###########################################")
    println(":::::::::::::: WELCOME TO MEMORY ::::::::::")
    println("###########################################")
    println("\n")

    println("Choose Card 1:")
    chooseCard
    println("Choose Card 1:")
    chooseCard


    if (boardController.compareCards()) {
      println("Match!!!")
    } else {
      println("No Match!!!")

    }

  }

  def chooseCard: MemoryCard = {
    val cardNr = StdIn.readInt()
    boardController.addCard(cards.apply(cardNr - 1))
  }

  override def receiveCardUpdate(): Unit = {
  }

  override def receiveGameUpdate(boolean: Boolean): Unit = {

  }
}

object Main {
  def main(args: Array[String]): Unit = {

    val tui = new Tui
    tui.startGame()
  }
}
