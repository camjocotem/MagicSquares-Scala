/**
  * Created by Jonny on 23/05/2017.
  */
object HelloWorld {
  /* This is my first java program.
  * This will print 'Hello World' as the output
  */
  val MAX_SAFE_SQUARABLE_NUMBER :Int = 605
  val inputs = getRange(MAX_SAFE_SQUARABLE_NUMBER)
  var arr :List[Int] = List(1, 1, 1, 1, 1, 1, 1, 1, 1)
  var success :Boolean = false

  def main(args: Array[String]) {
    println("Start")
    while(!success) {
      cartesian(inputs, None)
      calcMagicSquare(arr)
    }
  }

  def cartesian(inputs: List[Int], currentColumn: Option[Int]): List[Int] ={
    var currentColumnVal :Int = currentColumn.getOrElse(arr.length - 1)
    var currentItemsInputIndex = inputs.indexOf(arr(currentColumnVal));

    if(currentItemsInputIndex == inputs.length - 1){
      arr = arr.updated(currentColumnVal,inputs(0));
      arr = cartesian(inputs, Some(currentColumnVal - 1));
    }
    else{
      arr = arr.updated(currentColumnVal, inputs(currentItemsInputIndex + 1))
    }

    return arr;
  }

  def calcMagicSquare(inpArr: List[Int]): Boolean ={
    val a = inpArr(0)
    val b = inpArr(1)
    val c = inpArr(2)
    val d = inpArr(3)
    val e = inpArr(4)
    val f = inpArr(5)
    val g = inpArr(6)
    val h = inpArr(7)
    val i = inpArr(8)

    val rowA = a + b + c;
    val rowB = d + e + f;
    val rowC = g + h + i;
    val colA = a + d + g;
    val colB = b + e + h;
    val colC = c + f + i;
    val diagA = a + e + i;
    val diagB = g + e + c;

    if(rowA == rowB && rowB == rowC && rowC == colA && colA == colB && colB == colC && colC == diagA && diagA == diagB){
      println("Success!", arr);
      success = true;
      return true;
    }
    return false;
  }

  def getRange(max: Int): List[Int] ={
    return (1 to max).map(x => x*x).toList;
  }
}