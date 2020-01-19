package mpg.scala.controller.board

import java.awt.Color

import mpg.scala.model.board.{Board, CardCreator}
import mpg.scala.model.memorycard.MemoryCard
import mpg.scala.model.player.Player
import org.scalatest.{FunSuite, WordSpec}

class BoardControllerTest extends WordSpec {


  val playerOne: Player = Player(isActive = true, 0)
  val playerTwo: Player = Player(isActive = false, 0)
  val cards__ : Vector[MemoryCard] = new CardCreator().createRandomCardSet(2)
  var board: Board = Board(cards__)
  val boardController = new BoardController(board, playerOne, playerTwo)

  "The right amount of Memorycard Controllers" should {
    "should be created correctly" in {
      boardController.createCardControllers
      assert(4 == boardController.createCardControllers.size)
    }
  }
  "Flipped cards" should {
    "should be added correctly" in {
      boardController.addCard(cards__.apply(1))
      assert(1 == boardController.flippedCards.size)
    }
  }
  "Identical Cards" should {
    "should be compared correctly" in {
      boardController.flippedCards.clear()

      boardController.addCard(MemoryCard(new Color(1, 201, 243), Color.BLACK,
        state = false))
      boardController.addCard(MemoryCard(new Color(1, 201, 243), Color.BLACK,
        state = false))
      assert(boardController.compareCards())
    }
  }
  "Not identical Cards" should {
    "should be compared correctly" in {
      boardController.flippedCards.clear()

      boardController.addCard(MemoryCard(new Color(1, 201, 243), Color.GREEN,
        state = false))
      boardController.addCard(MemoryCard(new Color(1, 201, 243), Color.BLACK,
        state = false))
      assert(!boardController.compareCards())
    }
  }

  "Points" should {
    "should be added correctly" in {

      boardController.addPointsToActivePlayer()
      assert(1 == boardController.playerOne.points)
      boardController.changeActivePlayer()
      boardController.addPointsToActivePlayer()
      assert(1 == boardController.playerTwo.points)

    }
  }

  "Active player" should {
    "should be checked correctly" in {

      assert(1 == boardController.checkActivePlayer())
      boardController.changeActivePlayer()
      assert(2 == boardController.checkActivePlayer())

    }
  }
}
