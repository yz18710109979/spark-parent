package com.aura.bigdata.p4

object _03ProtectedOps {
  def main(args: Array[String]): Unit = {
    val cat = new Cat
    cat.eat()
  }
}

class Animal{
  var name : String = _
  var color : String = _
  protected[p4] var gender : Int = 0

  def eat() : Unit = {
    println("eat")
  }
}
class Cat extends Animal{
  name = "kitty"
  color = "pink"

  override def eat(): Unit = {
    println(s"有一只颜色为${color}，性别为${gender}，的名为${name}的铲屎官在卖萌")
  }

  def makeFriend(cat:Cat): Unit = {
    println(s"有一只颜色为${color}，性别为${gender}名为${name}的喵星人要和" +
      s"另一只颜色为${cat.color}，性别为${cat.gender}名为${cat.name}的交朋友")
  }
}