object Solution{
  
  var N:Int = 0;
  var K:Int = 0;
  var set:Set[Int] = Set();
  
  def main(args:Array[String]){
    readNK();
    readSet();
    var ans = 0;
    for(num <- set){
      if (set.contains(num + K))
	ans += 1;
    }
    println(ans);
  }

  def readNK(){
    var line = readLine();
    N = line.split(" ")(0).toInt;
    K = line.split(" ")(1).toInt;
  }
  
  def readSet(){
    var ints = readLine().split(" ");
    for(int <- ints){
      var num = int.toInt;
      set += num;
    }
  }
}
