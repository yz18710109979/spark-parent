package com.aura.bigdata.p4.superz
//超类的构造
object _04FuConstructorProcessOps {
  def main(args: Array[String]): Unit = {
    val stu = new Student("zs",22)
    stu.name = "zs"
    stu.age = 12
    stu.eat()
  }
}
class Person{
  println("--------Person主构造器------------")
  var name : String = _
  var age : Int = _

  def this(name : String , age : Int){
    this
    this.name = name
    this.age = age
    println("--------Person(name:String, age:Int)辅助构造器------------")
  }
  def eat() : Unit = {
    println("have a breakfast~~~")
  }
}

class Student(name : String , age : Int) extends Person(name,age) {
  var sid : Long = _
  println("--------Student主构造器------------")

  def this(sid : Long){
    this("zs",22)
    this.sid = sid
    println("--------Student(sid:Long)辅助构造器------------")
  }
  def morningReading(): Unit = {
    println(s"sid为$sid, 姓名为${name}的同学在读书")
  }

  override def eat(): Unit = {
    println("have a breakfast~~~")
  }
}
