package com.aura.bigdata.p3

object _03ConstructorOps {
  def main(args: Array[String]): Unit = {
    val t = new Teacher("周进", 33)
    println("=========^_^============")
    t.show()
    println("-----------------------")
    val tt = new Teacher()
    tt.show()
    println("----------===-------------")
    val t3 = new Teacher(0)
    t3.show()
  }
}

class Teacher(name:String,age:Int){//主构造器
  def this(){//无参的辅助构造器
    this("彭国宏", 23)
    println("-----this() -----")
  }
  var gender : Int = _
  def this(gender : Int){
    this()
    this.gender = gender//当局部变量名和成员变量名发生冲突，可以用this加以区分
    println("-----this(gender:Int)-----")
  }
  println("---(name:String, age:Int)---")
  def show(): Unit = {
    println(s"name: $name, age: $age")
  }
}
