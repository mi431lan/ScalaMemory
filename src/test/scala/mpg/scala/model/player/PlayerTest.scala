package mpg.scala.model.player

import org.scalatest.{WordSpec}

class PlayerTest extends WordSpec {




  "A player" should "receive points if both clicked cards matches" in {

    val player = new Player()
    val isAMatch = player.compareClickedCards(cardOne, cardTwo)
    assert(isAMatch, true)

  }

  "A players points" should "be calculated correct" in {

    val player = new Player()
    player.updatePoints(hasMatched) //true false
    val actualPlayerPoints = player.getPoints
    assert(actualPlayerPoints, 1)

    player.updatePoints(hasMatched) //true false
    actualPlayerPoints = player.getPoints
    assert(actualPlayerPoints, 2)

    player.updatePoints(hasNotMatched) //true false
    actualPlayerPoints = player.getPoints
    assert(actualPlayerPoints, 2)

  }
  "A players points" should{
    "be start at zero" in {
      val player = new Player()
      val playerPoints = player.getPoints
      assert(playerPoints, 0)
  }}

}
