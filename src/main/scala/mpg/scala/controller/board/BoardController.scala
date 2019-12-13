package mpg.scala.controller.board

import mpg.scala.model.board.Board
import mpg.scala.model.memorycard.MemoryCard
import mpg.scala.model.player.Player
import mpg.scala.observerpattern.{Observer, Subject}
import mpg.scala.ui.panels.BoardPanel

import scala.collection.mutable.ListBuffer

class BoardController(board: Board, playerOneModel: Player, playerTwoModel: Player) extends Subject {

  var flippedCards = new ListBuffer[MemoryCard]()
  var playerOne: Player = playerOneModel
  var playerTwo: Player = playerTwoModel


  def getCards: Vector[MemoryCard] = {

    board.cards
  }

  def addCard(card: MemoryCard): MemoryCard = {
    println("Add Card")
    flippedCards += card
    card
  }

  def checkGameStatus: Boolean = {

    val boolean = board.checkGameStatus
    boolean
  }

  def countGameMoveUp: Int = {
    val moves = board.countGameMoveUp
    moves
  }

  def getGameMoves: Int = {
    board.getGameMoves
  }

  def compareCards(): Boolean = {
    if (flippedCards.size > 1) {

      if (flippedCards.apply(0).frontSide.equals(flippedCards.apply(1).frontSide)) {
        flippedCards.clear()
        checkActivePlayer()
        notifyObserversGameUpdate(true)
        true
      } else {
        flippedCards.clear()
        changeActivePlayer()
        notifyObserversGameUpdate(false)

        false
      }
    } else {
      false
    }
  }

  def checkActivePlayer(): Unit = {
    if (playerOne.isActive) {
      playerOne = playerOne.addPoint(1)
    } else if (playerTwo.isActive) {
      playerTwo = playerTwo.addPoint(1)
    }
  }

  def changeActivePlayer(): Unit = {
    playerOne = playerOne.changeActive()
    playerTwo = playerTwo.changeActive()

  }

  def getPlayerOnePoints: Int = {
    playerOne.points
  }

  def getPlayerTwoPoints: Int = {
    playerTwo.points
  }
}
