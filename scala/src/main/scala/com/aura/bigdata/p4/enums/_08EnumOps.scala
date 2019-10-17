package com.aura.bigdata.p4.enums

//scala版本的枚举操作
object _08EnumOps {
  def main(args: Array[String]): Unit = {
    val mon = Weekday.MON
    val thu = Weekday.THU

    println("mon's id: " + mon.id)
    println("thu's id: " + thu.id)
    println("mon < thu: " + mon.<(thu))
  }
}

object Weekday extends Enumeration{
  val MON, TUE, WED, THU, FRI, SAT, SUN = Value
}
