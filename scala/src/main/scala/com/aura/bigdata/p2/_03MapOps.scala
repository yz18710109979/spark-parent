package com.aura.bigdata.p2

import scala.collection.mutable
object _03MapOps {
  def main(args: Array[String]): Unit = {

    mapOps()
    val map = mutable.Map[Int,String](1 -> "bigdate")
    //新增
    map(2) = "spark"
    map += (3 -> "hadoop")
    println("map : " + map)

    //遍历
    for ((key,value) <- map){
      println(s"key = ${key} , value = ${value}")
    }
    println("---------------------------------")
    map.foreach(kv => {
      println(s"key = ${kv._1} , value = ${kv._2}")
    })
  }

  def mapOps() : Unit = {
    var map = Map[Int,String](
      1 -> "hello",
      2 -> "world"
    )
    println(map)
    map = Map[Int,String](
      (3 -> "bigdata"),
      (4 -> "spark")
    )
    println(map)

    //获取
    val value = map(3)//如果key不存在，会报错
    println(s"value = ${value}")
    val valueOption = map.get(3)//get操作返回可能存在的值，存在返回为Some(值)，不存在返回None
    println(s"valueOption = ${valueOption}")
    //如果option有值，获取其中的值
    val name = valueOption.get
    println(s"name = ${name}")

    //判断
    val key = 2
    if(map.contains(key)){
      val ret = map(key)
      println(s"ret = ${ret}")
    }
    //使用get的方式获取之
    val ret = map.getOrElse(key,"hadoop")
    println(s"ret = ${ret}")

    //修改
    //新增
    map += (5 -> "hadoop")

    //删除
    val newMap = map.drop(1)
    println(s"newMap = ${newMap}")
  }
}
