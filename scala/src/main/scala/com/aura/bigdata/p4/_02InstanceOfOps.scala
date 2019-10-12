package com.aura.bigdata.p4
//类型检查和转换
object _02InstanceOfOps {
  def main(args: Array[String]): Unit = {
    val dog1 = new Dog("ml",2)
    val dog2 = new Dog("ml",2)

    println(dog1.equals(dog2))
  }
}

class Dog{
  var name : String = _
  var did : Int = _

  def this(name : String , did : Int){
    this
    this.name = name
    this.did = did
  }

  def canEqual(other : Any ) : Boolean = other.isInstanceOf[Dog]

  //  override def equals(other: Any): Boolean = {
  //      var flag = false
  //      if(canEqual(other)){
  //          //类型转换
  //          val dog = other.asInstanceOf[Dog]
  //          if(this.name.equals(dog.name) && this.did == dog.did)
  //              flag = true
  //      }
  //      flag
  //  }
  //模式匹配的写法
  override def equals(other: scala.Any): Boolean = {
    other match {
      case dog : Dog => this.name.equals(dog.name) && this.did == dog.did
      case _ => false
    }
  }

  override def hashCode(): Int = {11}

}
