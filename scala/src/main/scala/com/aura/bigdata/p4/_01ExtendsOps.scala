package com.aura.bigdata.p4

object _01ExtendsOps {
  def main(args: Array[String]): Unit = {
    val stu = new Student
    stu.sid = 1l
    stu.name = "zs"
    stu.age = 13
    stu.eat()
    stu.morningReading()
  }
}

/*final*/ class Person{
  var name : String = _
  var age : Int = _

  /*final*/ def eat() :Unit = {
    println("have a breakfast")
  }
}

class Student extends Person{
  var sid : Long = _

  def morningReading() : Unit = {
    println(s"sid = ${sid},姓名为${name}的学生在读书")
  }

  //scala中如果要复写父类的一个方法，必须要使用override关键修饰，除非该方法是抽象的
  override def eat(): Unit = {
    println("override hava a breakfast~~~~")
  }
}