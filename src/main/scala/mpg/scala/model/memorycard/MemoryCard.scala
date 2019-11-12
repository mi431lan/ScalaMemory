package mpg.scala.model.memorycard

import javafx.scene.image.Image
import javafx.scene.shape.Box

case class MemoryCard() {

  val box = new Box(50, 40, 60)
  val backSide= "backside.png"

  val csharp1 = "csharp.png";
  val csharp2 = "csharp.png";

  val java1 = "java.jpg";
  val java2 = "java.jpg";

  val kotlin1 = "Kotlin.png";
  val kotlin2 = "Kotlin.png";

  val python1 = "python.jpg";
  val python2 = "python.jpg";

  val scala1 = "scala.jpg";
  val scala2 = "scala.jpg";

  var frontSide= {new Image(csharp1)
    new Image(csharp2)
    new Image(java1 )
    new Image(java2 )
    new Image(kotlin1)
    new Image(kotlin2)
    new Image(python1)
    new Image(python2)
    new Image(scala1)
    new Image(scala2) }


def drawFaceDown(box: Box): Unit ={
    backSide
}
  def drawFaceUp(box: Box): Unit ={
    frontSide
  }
  //TODO: method card status : frontSide or backSite


  mouseClicked = function() {
    // verarbeiten den Klick
  }

  //TODO: flip when Player clicks , change state of card


}
