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

    flippedCards += card
    card
  }

  def compareCards(): Boolean = {

    if (flippedCards.size > 1) {

      if (flippedCards.apply(0).frontSide.equals(flippedCards.apply(1).frontSide)) {
        flippedCards.clear()
        addPointsToActivePlayer()
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

  def addPointsToActivePlayer(): Int = {

    if (playerOne.isActive) {
      playerOne = playerOne.addPoint()
      return playerOne.points
    } else if (playerTwo.isActive) {
      playerTwo = playerTwo.addPoint()
      return playerTwo.points
    }
    0
  }

  def checkActivePlayer(): Int = {

    if (playerOne.isActive) {
      1
    } else {
      2
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
