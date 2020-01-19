package mpg.scala.model.player

case class Player(isActive: Boolean, points: Int) {


  def addPoint(): Player = {

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
