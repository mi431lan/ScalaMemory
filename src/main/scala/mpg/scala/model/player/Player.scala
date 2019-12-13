
package mpg.scala.model.player

import mpg.scala.model.memorycard.MemoryCard

case class Player(isActive: Boolean, points: Int) {


  def addPoint(point: Int): Player = {
    Player(isActive, points + 1)

  }

  def changeActive(): Player = {
    if (isActive) {
      Player(isActive = false, points)
    } else {
      Player(isActive = true, points)

    }

  }

}
