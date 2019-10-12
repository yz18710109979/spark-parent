package com.aura.bigdata.p2

import scala.collection.mutable.ArrayBuffer

//scala的可变数组操作
object _02ArrayBufferOps {
  def main(args: Array[String]): Unit = {
//    createArr
    val ab = ArrayBuffer[Int](1,2,3)
    println("初始数组内容：" + ab)
    //增
    ab.append(4)//在数组的末尾添加一个元素
    println("添加一个元素之后数组的内容：" + ab)

    ab += 5//在数组末尾添加一个元素
    println("添加一个元素之后的数组内容：" + ab)

    //元素插入
    ab.insert(3,-3,-4)
    println("在index为3的值为插入一个元组之后的数组内容：" + ab)

    //添加一个集合
    var newAb =ab.++(Array(6,7,8))
    println("添加一个集合之后的数组内容：" + newAb)

    ab ++= Array(6, 7, 8)
    println("添加一个集合之后的数组内容：" + ab)

    //改
    ab(3) = -7
    println(ab)

    //删除
    newAb.drop(2)//删除前N个元素并返回一个新的数组，原数组不变
    println("ab.drop(2)之后的数组内容：" + newAb)
    newAb = ab.dropRight(2)//从后往前删除N个元素，并返回一个新的数组，原数组不变
    println("ab.dropRight(2)之后的数组内容：" + newAb)

    val ret = ab.remove(3)//删除指定索引位置上元素，并返回
    println("ret: " + ret)
    println("ab.remove(3)之后的数组内容：" + ab)
    ab.remove(3, 2)//从指定索引位置开始删除n个元素
    println("ab.remove((3, 2)之后的数组内容：" + ab)

    //遍历
    for (s <- ab){
      println("遍历：" + s)
    }
    //foreach
    ab.foreach(s => println("foreach：" + s))
  }
  def createArr = {
    //使用new创建
    val ab : ArrayBuffer[Int] = new ArrayBuffer[Int]()
    println(ab)
    //使用伴生对象创建
    val ab2 = ArrayBuffer[Int](1,2,3,4,5,6,7,8,9,0)
    println(ab2)
  }
}
