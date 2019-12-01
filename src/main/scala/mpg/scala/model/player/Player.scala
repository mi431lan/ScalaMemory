
package mpg.scala.model.player

import mpg.scala.model.memorycard.MemoryCard

case class Player() {


  //add also var turn Boolean
  //val name: String, var points: Int-> als Parameter

  /*val csharp1 = "csharp.png";
  val csharp2 = "csharp.png";

  val java1 = "java.jpg";
  val java2 = "java.jpg";

  val kotlin1 = "Kotlin.png";
  val kotlin2 = "Kotlin.png";

  val python1 = "python.jpg";
  val python2 = "python.jpg";

  val scala1 = "scala.jpg";
  val scala2 = "scala.jpg";

   */

  val cardOne = new MemoryCard
  val cardTwo = new MemoryCard
  var isAMatch: Boolean = true

  //Method:CompareTwoCards,if Match get points
  def compareClickedCards(cardOne: MemoryCard, cardTwo: MemoryCard): Boolean = {
    if (isAMatch) {

    }
    return true
  }

  //Method: Comparison between 2 cards
  /*
    if (java1 == java2) {
      println("Cards are the same.")
    }
    if (csharp1 == csharp2) {
      println("Cards are the same.")
    }
    if (kotlin1 == kotlin2) {
      println("Cards are the same.")
    }
    if (python1 == python2) {
      println("Cards are the same.")
    }
    if (scala1 == scala2) {
      println("Cards are the same.")
    }*/

  //alternative Method for comparison of 2 cards

  /*def isAMatch(): Boolean = {
    val pic = for (csharp1
    , csharp2
    , java1
    , java2
    , kotlin1
    , kotlin2
    , python1
    , python2
    , scala1
    , scala2
    )
    {
      if (csharp1 == csharp2 || java1 == java2 || kotlin1 == kotlin2 || python1 == python2 || scala1 == scala2)
        "The Cards match"
      return true;
    }
    false
  }*/

  //Method to get Points
  private var counter = 0

  def getPoints(): Int = {
    if (true) {
      counter += 1
    }
    return counter
  }

  //Update Points

  var hasMatched = false
  val playerPoints: Int = getPoints()
  var startpoint: Int = 0
  def updatePoints(): Int = {
    if (!hasMatched) {

      var playerPoints: Int = startpoint + getPoints()

    }
    return playerPoints

  }
}

