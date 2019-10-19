package com.aura.bigdata.p6

//通过隐式转换参数
object _05ImplicitOps {
    def main(args: Array[String]): Unit = {
        val list = List(-3, 6, 0, 7, 1, -5, 2)
        implicit val order = new Ordering[Int]() {
            override def compare(x: Int, y: Int) = {
                x.compareTo(y)
            }
        }
        list.sorted(order).foreach(println)
    }
}
