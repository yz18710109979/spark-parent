package com.aura.bigdata.p4.funcs
//scala函数式编程
object _01FunctionOps {
  def main(args: Array[String]): Unit = {
//    functionOps1
//    functionOps2
  }
  //匿名函数
  def functionOps2 : Unit ={
    val test = (name : String) => {
      println("good bye, " + name)
    }
    test("test")
  }
  //作为值的函数
  def functionOps1 = {
    def sayGoodBye(name : String) = {
      println("good bye, " + name)
    }
    //
    def bye  = sayGoodBye _
    bye("spark")

    val test = sayGoodBye _
    test("test")
  }
}
