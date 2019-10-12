package com.aura.bigdata.p3
//模拟java中的静态行为
object _05ObjectOps {
  def main(args: Array[String]): Unit = {
    //        val worker = new Worker()
    val worker = Worker()
    val worker1 = Worker("heihe", 13)

    Worker.print()
  }
}

class Worker {
  var name:String = "工人"
  var workAge:Int = 0

  def show(): Unit = {
    println(s"$name ---> $workAge")
  }

  def this(name:String, workAge:Int)  {
    this()
    this.name = name
    this.workAge = workAge
  }
}

object Worker {
  def apply():Worker = {
    new Worker
  }
  def apply(name:String, workAge:Int):Worker = {
    new Worker(name, workAge)
  }

  def print(): Unit = {//模拟java中的类的静态方法
    println("----print")
  }
}