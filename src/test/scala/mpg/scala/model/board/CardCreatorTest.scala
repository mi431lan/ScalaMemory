package mpg.scala.model.board

import java.awt.Color

import org.scalatest.WordSpec

class CardCreatorTest extends WordSpec {

  "A Cardset" should {
    "should have the correct amount of cards" in {
      val cardSet = CardCreator().createRandomCardSet(24)
      assert(24 == cardSet.size)
    }
  }

  "A random color" should {
    "should be generated correctly" in {
      val color = CardCreator().createRandomColor(0, 0, 0);
      assert(new Color(0, 0, 0) == color)
    }
  }

}
