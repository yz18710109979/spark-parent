package com.aura.bigdata.p2

object _04TupleOps {
  def main(args: Array[String]): Unit = {
    val tuple = new Tuple2[Int,String](1,"zhangsan")
    //获取第一个元组
    val id = tuple._1
    val name = tuple._2
    println(s"id = ${id} , name = ${name}")

    val tuple4 = new Tuple4("spring","summer","autumn","winter")
    val spring1 = tuple4._1
    println(s"spring1 = ${spring1}")
    val (spring, summer, autumn, winter) = new Tuple4("spring", "summer", "autumn", "winter")
    println("autumn: " + autumn)
    //最简单的写法
    val (spring2, summer2, autumn2, winter2) = ("spring", "summer", "autumn", "winter")
    println("autumn2: " + autumn2)
    //遍历
    for (t <- tuple4.productIterator){
      println(s"遍历 = ${t}")
    }
  }
}
