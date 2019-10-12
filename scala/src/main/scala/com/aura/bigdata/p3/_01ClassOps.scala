package com.aura.bigdata.p3

object _01ClassOps {
  def main(args: Array[String]): Unit = {
    val p : Person = new Person()//创建一个scala的Person对象
    p.name = "zhangsan"
    p.age = 30
    p.show()
  }
}
class Person{
  //成员变量 如果后续要修改成员变量，必须声明为var 如果声明为val则必须要初始化
  var name : String = _
  var age : Int = _

  def show() : Unit = {
    println(s"name = ${name} , age = ${age}")
  }
}
