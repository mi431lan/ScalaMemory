package mpg.scala.model.memorycard


case class MemoryCard() {

  var cardstate=false
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

def getCardState (): Boolean ={
  cardstate
}
  //method if player clicks on card, flip Card
  def flipCardToFrontSide(): Unit ={
    if(!cardstate){
      cardstate=true;
    }
  }
  def flipCardToBackSide(): Unit ={
    if(cardstate){
      cardstate=false
    }
  }



}
