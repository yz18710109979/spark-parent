package com.aura.bigdata.p4.funcs
//scala函数式编程
object _01FunctionOps {
  def main(args: Array[String]): Unit = {
//    functionOps1
//    functionOps2
//    functionOps3
//    functionOps4
  }
  //参数（类型）推断
  def functionOps4 : Unit = {
    def calc(num : Int,func : (Int) => Int) = {
      val ret = func(num)
      println("ret : " + ret)
    }
    //
    calc(5,(num : Int) => num * 2)
    //类型推断
    calc(10,(num) => num * 2)
    ////如果函数参数，只有一个(外层函数，这里就是calc)参数，可以省略掉这个()
    calc(5,num => num * 10)
    //可以做到最简洁，将的参数变量使用通配符"_"代替
    calc(5, _ * 2)
  }
  //带函数参数的函数（高阶函数）
  def functionOps3 : Unit = {
    def sayGoodBye(name : String,func : (String) => Unit) : Unit = {
      func(name)
    }
    sayGoodBye("zs",name => {println("good bye : " + name)})
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
