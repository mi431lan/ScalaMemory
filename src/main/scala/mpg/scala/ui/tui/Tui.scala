package mpg.scala.ui.tui

import java.awt.Color

import javax.swing.JMenuItem
import mpg.scala.controller.board.BoardController
import mpg.scala.controller.memorycard.MemoryCardController
import mpg.scala.model.board.{Board, CardCreator}
import mpg.scala.model.memorycard.MemoryCard
import mpg.scala.model.player.Player
import mpg.scala.observerpattern.{Observer, Subject}
import mpg.scala.ui.panels.{BoardPanel, MemoryCardPanel}

import scala.io.StdIn
import scala.swing.{Dimension, Label, MainFrame}

class Tui(boardController: BoardController) extends Observer {

  var count = 0;

  def startGame(): Unit = {
    boardController.addObserver(this)
    for (n <- boardController.cardControllers) {
      n.addObserver(this)
      println("aaa")
    }
    println("###########################################")
    println(":::::::::::::: WELCOME TO MEMORY ::::::::::")
    println("###########################################")
    println("\n")

    makeGameMove()
    while (count != boardController.getCards.size) {
      makeGameMove()
    }

  }

  def makeGameMove(): Unit = {
    println("Choose Card 1:")
    chooseCard
    println("Choose Card 2:")
    chooseCard

    if (boardController.compareCards()) {
      println("Match!!!")
    } else {
      println("No Match!!!")

    }
  }

  def chooseCard: MemoryCard = {
    val cardNr = StdIn.readInt()
    boardController.cardControllers.apply(cardNr - 1).flipCardToFrontSide()
    boardController.addCard(boardController.getCards.apply(cardNr - 1))
  }

  override def receiveCardUpdate(): Unit = {
  }


  override def receiveGameUpdate(boolean: Boolean): Unit = {
    println("Points P1: " + boardController.playerOne.points)
    println("Points P2: " + boardController.playerTwo.points)
    if (boolean) {

      count = count + 2
    }
    if (count == boardController.getCards.size) {
      if (boardController.playerOne.points > boardController.playerTwo.points) {
        println("Player One has won!!")
      } else
        println("Player Two has won!!")
    }
  }
}
