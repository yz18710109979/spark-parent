package com.aura.bigdata.p3

object _04NestClassOps {
  def main(args: Array[String]): Unit = {
    val outer = new Outer
    val inner = new outer.Inner()
    inner.show()
  }
}

class Outer { oooooo =>
  val x = 5

  class Inner { iii =>
    val x = 6
    def show(): Unit = {
      val x = 7
      println("x: " + x)
      println("x: " + iii.x + "-->" + this.x)
      println("x: " + oooooo.x + "-->" + Outer.this.x)
    }
  }
}