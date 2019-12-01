package mpg.scala.model.memorycard

import scala.swing.Color


case class MemoryCard(back: Color, front: Color, state: Boolean) {

  private val cardState: Boolean = state
  //TODO Bilder statt farben einfügen
  private val backSide: Color = back
  private val frontSide: Color = front


  def getCardState: Boolean = {

    println("Card state is " + cardState)
    cardState
  }

  def getBackSide: Color = {

    backSide
  }

  def getFrontSide: Color = {

    frontSide
  }

  def getActiveBackground: Color = {

    if (getCardState) {
      getFrontSide
    } else {
      getBackSide
    }
  }

  def flipCardToFrontSide(): MemoryCard = {

    if (!cardState) {
      println("Flipped card to front side")
      MemoryCard(back, front, state = true)
    } else {
      println("Flipped")

      MemoryCard(back, front, state = false)

    }
  }

  def flipCardToBackSide(): MemoryCard = {

    if (cardState) {
      println("Flipped card to back side")
      MemoryCard(back, front, state = false)
    } else {
      MemoryCard(back, front, state = true)
    }
  }
}

