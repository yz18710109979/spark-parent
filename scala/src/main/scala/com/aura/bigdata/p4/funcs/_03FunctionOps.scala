package com.aura.bigdata.p4.funcs

//闭包
object _03FunctionOps {
  def main(args: Array[String]): Unit = {
//    closePackage
    currying
  }
  def closePackage : Unit = {
    def mulBy(factor : Double) = (x :Double) => factor * x
    val triple =mulBy(3)
    val half = mulBy(0.3)
    println(triple(14) + " " + half(14)) //42 7
  }
  def currying: Unit ={
    //        def mulBy(factor:Double) = (x:Double) => factor * x
    def mulBy(factor:Double, x:Double) = factor * x
    def curryingMethod(factor:Double)(x:Double) = factor * x
    println(mulBy(3, 14) +" " + mulBy(0.5, 14)) //42, 7
    println(curryingMethod(3)(14) +" " + curryingMethod(0.5)(14)) //42, 7
  }
}
