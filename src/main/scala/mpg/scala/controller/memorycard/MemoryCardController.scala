package mpg.scala.controller.memorycard

import java.awt.Color
import mpg.scala.model.memorycard.MemoryCard
import mpg.scala.observerpattern.{Subject}

case class MemoryCardController(memoryCardModel: MemoryCard) extends Subject {

  var memoryCard: MemoryCard = memoryCardModel

  def getCard: MemoryCard = memoryCard

  def getBackSide: Color = memoryCard.backSide

  def getFrontSide: Color = memoryCard.frontSide

  def getActiveBackground: Color = memoryCard.getActiveBackground

  def flipCardToFrontSide(): Color = {

    memoryCard = memoryCard.flipCardToFrontSide()
    notifyObserversCardUpdate()
    memoryCard.getActiveBackground
  }

  def flipCardToBackSide(): Color = {

    memoryCard = memoryCard.flipCardToBackSide()
    memoryCard.getActiveBackground
  }
}
