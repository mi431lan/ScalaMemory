package mpg.scala.model.board

import mpg.scala.model.memorycard.MemoryCard

case class Board(cards: Vector[MemoryCard], gameMoves: Int) {

  val cards_ : Vector[MemoryCard] = cards
  var gameMoves_ = 0;

  def getCardsCount: Int = {

    cards_.length
  }

  def checkGameStatus: Boolean = {

    if (gameMoves_ == 3) {
      println("Two cards flipped, reset..")
      resetCards
      resetGameMoves
      return true
    }
    false
  }

  def getCards: Vector[MemoryCard] = {

    cards_
  }

  def getGameMoves: Int = {

    gameMoves_
  }

  def resetCards: String = {

    for (n <- cards_) n.flipCardToBackSide()
    val returnVal = "Card reset"
    returnVal
  }

  def resetGameMoves: Int = {
    gameMoves_ = 0;
    gameMoves_
  }

  def countGameMoveUp: Int = {
    gameMoves_ += 1
    gameMoves_
  }

  def compareCards(card1: MemoryCard, card2: MemoryCard): Boolean = {

    if (card1.getFrontSide.equals(card2.getFrontSide)) {
      true
    } else false
  }

}
