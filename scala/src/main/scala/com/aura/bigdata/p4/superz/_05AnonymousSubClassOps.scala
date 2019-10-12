package com.aura.bigdata.p4.superz

//匿名子类
object _05AnonymousSubClassOps {
  def main(args: Array[String]): Unit = {
     val p = new Person(){
       var hairColor = "nnh"
       def show() : Unit = {
         println(s"name = ${name} $age $hairColor")
       }
     }
    p.show()
  }
}
