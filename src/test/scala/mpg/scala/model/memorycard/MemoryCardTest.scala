package mpg.scala.model.memorycard

import org.scalatest.WordSpec

class MemoryCardTest extends WordSpec {
  "A Card" should {
    "not be flipped when the game starts" in{
      val card = new MemoryCard;
      val cardState:Boolean = card.getCardState(); // muss funktional nicht oop sein
      assert(!cardState)
    }
  }

  "A Card" should {
    "be flipped on clickAction" in {

      var card = new MemoryCard();
      card.flipCardToBackSide();
      val cardState = card.getCardState();
      assert(!cardState)

    }
  }
}
