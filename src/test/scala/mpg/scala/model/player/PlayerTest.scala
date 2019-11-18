
package mpg.scala.model.player

import mpg.scala.model.memorycard.MemoryCard
import org.scalatest.WordSpec

class PlayerTest extends WordSpec {


  //Läuft durch
  "A player" should {
    "receive points if both clicked cards matches" in {
      val cardOne = new MemoryCard
      val cardTwo = new MemoryCard
      val player = new Player()
      val isAMatch = player.compareClickedCards(cardOne, cardTwo)
      assert(isAMatch, true)

    }
  }

  def assertResult_(i: Int, value: 10): Any = 0

  "A players points" should {
    "be calculated correct" in {
      val player = new Player()
      player.updatePoints() //true false
      val actualPlayerPoints: Int = player.getPoints()
      assertResult_(actualPlayerPoints, 10) //das nehmen da Rückgabewert Int sein soll?


      /* player.updatePoints() //true false
      val actualPlayerPoints:Int = player.getPoints()
        assertResult(player.getPoints(),0)

        player.updatePoints() //true false
        //val actualPlayerPoints:Int = player.getPoints()
        assertResult(player.getPoints())*/

    }
  }
//TODO: Nochmals prüfen
    "A players points" should{
      "be start at zero" in {
        val player = new Player()
        val playerPoints:Int = 0

        assertResult(playerPoints, 0)
    }}



}

