package mpg.scala.model.board

import java.awt.Color

import mpg.scala.model.memorycard.MemoryCard

case class CardCreator() {


  def createRandomCardSet(size: Int): Vector[MemoryCard] = {

    val r = scala.util.Random
    val cardSet = Vector.fill(size / 2)(MemoryCard(new Color(1, 201, 243),
      createRandomColor(r.nextInt(256), r.nextInt(256), r.nextInt(256)),
      state = false))
    val cardSetTwo = cardSet ++ cardSet
    cardSetTwo
  }

  def createRandomColor(red: Int, green: Int, blue: Int): Color = {

    val randomColor = new Color(red, green, blue)
    randomColor
  }


}
