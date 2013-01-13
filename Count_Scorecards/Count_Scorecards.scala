object Solution{

  def main(args: Array[String]) {
    var line = readLine().trim;
    val T = line.toInt;

    for(i <- 0 until T){
      line = readLine().trim;
      val N = line.toInt;
      var scores = new Array[Int](N);
      line = readLine().trim;
      var i = 0;
      for(str <- line.split(" ")){
	scores(i) = str.toInt;
	i += 1;
      }
      println(work(N, scores));
    }
  }
  
  def work(N: Int, scores: Array[Int]): Int = {
    val maxWin = N-1;
    var left = N*(N-1) / 2;
    var numOfUnknown = 0;
    for(score <- scores) {
      if (score > maxWin)
	return 0;
      if (score == -1)
	numOfUnknown += 1;
      else
	left -= score;
    }
    
    if (left < 0)
      return 0;
    
    if (left == 0)
      return 1;

    var last = new Array[Int](left + 1);    
    
    var now= new Array[Int](left + 1);

    for (i <- 0 until left+1)
      if (i <= maxWin)
	now(i) = 1;
      else now(i) = 0;
      
    for (i <- 1 until numOfUnknown){
      last = now;
      now = new Array[Int](left+1);
      for (j <- 0 until left+1){
	for (k <- 0 until maxWin+1)
	  if (j - k >= 0)
	    now(j) += last(j - k);
      }
    }
    
    return now(left);
  }

}
