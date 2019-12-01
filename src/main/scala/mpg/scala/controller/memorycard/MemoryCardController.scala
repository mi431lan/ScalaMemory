package mpg.scala.controller.memorycard

import java.awt.Color

import mpg.scala.model.memorycard.MemoryCard

case class MemoryCardController(memoryCardModel: MemoryCard) {

  def getBackSide: Color = {

    memoryCardModel.getBackSide
  }

  def getFrontSide: Color = {

    memoryCardModel.getFrontSide
  }

  def getActiveBackground: Color = {

    memoryCardModel.getActiveBackground
  }

  def flipCardToFrontSide(): Color = {

    val card = memoryCardModel.flipCardToFrontSide()

    card.getActiveBackground
  }

}
