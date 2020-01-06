package mpg.scala.model.memorycard


import java.awt.Color

import org.scalatest.WordSpec


class MemoryCardTest extends WordSpec {

  "A Card" should {
    "have the right active background while card state is false" in {
      val card = new MemoryCard(new Color(0, 0, 0), new Color(1, 1, 1), state = false)
      val color = card.getActiveBackground
      assert(new Color(0, 0, 0) == color)
    }
  }

  "A Card" should {
    "have the right active background while card state is true" in {
      val card = new MemoryCard(new Color(0, 0, 0), new Color(1, 1, 1), state = true)
      val color = card.getActiveBackground
      assert(new Color(1, 1, 1) == color)
    }
  }

  "A Card" should {
    "be flipped to front side correctly" in{
      val card =  new MemoryCard(new Color(0,0, 0),new Color(1, 1, 1),state = false)
      val flippedCard = card.flipCardToFrontSide()
      assert(flippedCard.state==true)
    }
  }

  "A flipped Card" should {
    "should be flipped to back side correctly" in{
      val card =  new MemoryCard(new Color(0,0, 0),new Color(1, 1, 1),state = true)
      val flippedCard = card.flipCardToFrontSide()
      assert(flippedCard.state==false)
    }
  }
  "A Card" should {
    "be flipped to back side correctly" in{
      val card =  new MemoryCard(new Color(0,0, 0),new Color(1, 1, 1),state = true)
      val flippedCard = card.flipCardToBackSide()
      assert(flippedCard.state==false)
    }
  }

  "A flipped Card" should {
    "should be flipped to front side correctly" in{
      val card =  new MemoryCard(new Color(0,0, 0),new Color(1, 1, 1),state = false)
      val flippedCard = card.flipCardToBackSide()
      assert(flippedCard.state==true)
    }
  }
}
