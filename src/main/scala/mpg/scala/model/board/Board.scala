package mpg.scala.model.board

import mpg.scala.model.memorycard.MemoryCard
import mpg.scala.observerpattern.{Observer, Subject}

import scala.collection.mutable.ListBuffer

case class Board(cards: Vector[MemoryCard], gameMoves: Int) {

  var gameMoves_ = 0;


  def checkGameStatus: Boolean = {

    if (gameMoves_ == 2) {
      resetGameMoves
      return true
    }
    false
  }


  def getGameMoves: Int = {

    gameMoves_
  }

  def resetCards: String = {

    for (n <- cards) n.flipCardToBackSide()
    val returnVal = "Card reset"
    returnVal
  }

  def removeMatchedCards(card1: MemoryCard, card2: MemoryCard): String = {

    cards.diff(Seq(card1, card2))
    ""
  }

  def resetGameMoves: Int = {

    gameMoves_ = 0;
    gameMoves_
  }

  def countGameMoveUp: Int = {

    gameMoves_ += 1
    gameMoves_
  }

  def compareCards(): Boolean = {

  /*  if (flippedCards.size > 1) {

      if (flippedCards.apply(0).frontSide.equals(flippedCards.apply(1).frontSide)) {
        println("match")
        flippedCards.clear()
        true
      } else {
        println("no match")
        flippedCards.clear()
        false
      }
    }else {
      false
    }*/
    false
  }

}
