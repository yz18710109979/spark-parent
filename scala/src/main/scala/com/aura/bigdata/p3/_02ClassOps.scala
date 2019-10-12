package com.aura.bigdata.p3

import scala.beans.BeanProperty

object _02ClassOps {
  def main(args: Array[String]): Unit = {
    val s : Student = new Student()
    s.setName("zs")
    s.setAge(22)
    s.show()
  }
}
class Student{
  private var name : String = _
  //使用注解@BeanProperty，模拟java中的setter/getter,但是得需要吧private去掉
  @BeanProperty var age : Int = _

  def setName(n : String) : Unit = name = n
  def getName() = name

  def  show() : Unit = {
    println(s"name = ${name} , age = ${age}")
  }
}