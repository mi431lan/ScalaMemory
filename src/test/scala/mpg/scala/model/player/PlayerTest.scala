package mpg.scala.model.player

import java.awt.Color

import mpg.scala.model.memorycard.MemoryCard
import org.scalatest.WordSpec

class PlayerTest extends WordSpec {

  "A Player" should {
    "should get points correctly" in {
      val player = Player(isActive = true, 0);
      val playerNew = player.addPoint()
      assert(1 == playerNew.points)
    }
  }

  "A active Player" should {
    "should be set inactive correctly" in {
      val player = Player(isActive = true, 0);
      val playerNew = player.changeActive()
      assert(!playerNew.isActive)
    }
  }

  "A inactive Player" should {
    "should be set active correctly" in {
      val player = Player(isActive = false, 0);
      val playerNew = player.changeActive()
      assert(playerNew.isActive)
    }
  }

}


