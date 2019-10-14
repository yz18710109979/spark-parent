package com.aura.bigdata.p4.abstacts

object _06AbstractOps {

}

abstract class Animal{
  var leg : Int = _
  def shot() : Unit
}

class Dog extends Animal{
  override def shot(): Unit = ???
}