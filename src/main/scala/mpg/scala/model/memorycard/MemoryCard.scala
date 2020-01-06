package mpg.scala.model.memorycard

import scala.swing.Color

case class MemoryCard(backSide: Color, frontSide: Color, state: Boolean){

  private val cardState: Boolean = state

  def getActiveBackground: Color = {

    if (state) {
      frontSide
    } else {
      backSide
    }
  }

  def flipCardToFrontSide(): MemoryCard = {

    if (!cardState) {
      MemoryCard(backSide, frontSide, state = true)
    } else {
      MemoryCard(backSide, frontSide, state = false)
    }
  }

  def flipCardToBackSide(): MemoryCard = {

    if (cardState) {
      MemoryCard(backSide, frontSide, state = false)
    } else {
      MemoryCard(backSide, frontSide, state = true)
    }
  }
}

