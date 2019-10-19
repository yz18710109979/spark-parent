package com.aura.bigdata.p6

import MyImplicits._

object _03ImplimciOps {
  def main(args: Array[String]): Unit = {

    /*
        隐式转换，让下面的不可能，变成了可能 -->隐式转换函数来实现
        隐式转换函数和普通的函数的区别：
          1、必须以implicit开头
          2、必须有返回值，返回值类型就是要转换的类型
          3、定义隐式转换函数的时候，通常命名规则为：src2Dest
     */
    //        implicit def double2String(d:Double):String = d.toString
    //        import MyImplicits.double2String
    val str:String = 3.5
    //        import MyImplicits.str2Double
    val d:Double = "abcdefg"
  }
}
