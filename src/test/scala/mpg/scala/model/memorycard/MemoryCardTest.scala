package mpg.scala.model.memorycard

import org.scalatest.WordSpec

class MemoryCardTest extends WordSpec {
  "A Card" should {
    "not be flipped when the game starts" in{

      val card = new MemoryCard;
      val cardState = card.getCardState(); // muss funktional nicht oop sein
      assert(cardState, false)

    }
  }

  "A Card" should {
    "be flipped on clickAction" in {

      val card = new MemoryCard();
      card.flipCardToFrontSide();
      val cardState = card.getCardState();
      assert(cardState, true)

    }
  }
}
