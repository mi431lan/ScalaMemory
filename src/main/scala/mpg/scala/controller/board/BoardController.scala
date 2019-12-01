package mpg.scala.controller.board

import mpg.scala.model.board.Board
import mpg.scala.model.memorycard.MemoryCard

class BoardController(board: Board) {

  var board__ : Board = board

  def getCards: Vector[MemoryCard] = {

    board__.getCards
  }

  def checkGameStatus: Boolean = {

    board.checkGameStatus
  }

  def countGameMoveUp: Int = {

    board__.countGameMoveUp
  }

  def getGameMoves: Int = {

    board__.getGameMoves
  }

}
