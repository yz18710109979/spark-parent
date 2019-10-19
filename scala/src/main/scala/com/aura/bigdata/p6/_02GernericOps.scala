package com.aura.bigdata.p6

object _02GernericOps {
  def main(args: Array[String]): Unit = {
    val myList:MyList[Object] = new MyList[String]()
    val myList2:MyList2[String] = new MyList2[Object]()
  }
}
class MyList[+T] {//泛型的协变
}


class MyList2[-T] {//泛型的逆变
}