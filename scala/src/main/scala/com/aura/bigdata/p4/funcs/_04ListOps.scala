package com.aura.bigdata.p4.funcs
//List操作
object _04ListOps {
  def main(args: Array[String]): Unit = {
//    listOps1
    listOps2
  }
  def listOps2 : Unit = {
    val list = List(1, -1, 7, 9, 3, 2, 0)
    val sortedList = list.sortWith((num1 : Int,num2 : Int) => num1 < num2)
    println("原list： " + list)
    println("排序之后的list： " + sortedList)
    println("------sortBy--------")
    val stuList = List(
      "wangyuan 23",
      "yanlaibin 27",
      "jiajingkai 33",
      "taojie 18"
    )
    stuList.sortBy(stuLine => stuLine.split(" ")(1).toInt)(new Ordering[Int](){
      override def compare(x: Int, y: Int) = x.compareTo(y)
    }).foreach(println)

    println("------sorted--------")
    stuList.sorted(new Ordering[String](){
      override def compare(x: String, y: String) = {
        val xAge = x.split(" ")(1).toInt
        val yAge = y.substring(y.indexOf(" ") + 1).toInt
        yAge.compareTo(xAge)
      }
    }).foreach(println)
  }
  def listOps1 : Unit = {
    val left = List(1,2,3,4)
    val right = List(5,6,7,8)
    println("原集合left： " + left.mkString(","))

    //增元素
    //做首部加入一个元素，形成一个新的集合，原集合不变
    var ret = left.+:(5)
    println("left.+:(5) =》" + ret.mkString(","))
    //做首部加入一个元素，形成一个新的集合，原集合不变
    ret = left.::(5)
    println("left.::(5) =》" + ret)
    //做尾部加入一个元素，形成一个新的集合，原集合不变
    ret = left.:+(5)
    println("left.:+(5) =》" + ret)

    //增集合
    //做尾部加入一个集合，形成一个新的集合，原集合不变
    ret = left.++(right)
    println("left.++(right) =》" + ret)
    //做首部加入一个集合，形成一个新的集合，原集合不变
    ret = left.:::(right)
    println("left.:::(right) =》" + ret)
    //做首部加入一个集合，形成一个新的集合，原集合不变
    ret = left.++:(right)
    println("left.++:(right) =》" + ret)

    //删除操作
    //删除2个元素，生成一个新的集合，原集合不变
    val newLeft = left.drop(2)
    println(s"left: $left, newLeft: $newLeft")

    //访问 ---> IndexSeq的子trait，所以可以通过下标来进行访问，也就是和数组差不多(index)

    val first = left(0)
    val head = left.head
    println(s"first: $first, head: $head")
  }
}
