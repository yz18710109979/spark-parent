package com.aura.bigdata.p2
// 定长数组的操作
object _01ArrayOps {

  def main(args: Array[String]): Unit = {
    createArr
    val arr = Array("hello","world","hehe","bigdata")
    //获取数组的元素，使用下标索引，在java中arr[index],scala中所有的下标索引一律使用(index)
    val first = arr(0)
    println("arr数组下标第一个元素：" + first)
    //修改操作，无新增和删除操作
    arr(0) = "yangz"
    println(arr(0))
    //遍历
    for (s <- arr){
      println(s)
    }
  }

  def createArr = {
    val arr : Array[String] = new Array[String](3)
    println(arr)
    val arr1 = new Array[Int](3)
    println(arr1)
    //使用数组类的伴生对象
    val arr2 = Array[Int](1,2,3,4,5,6,7,8,9,0)
    println(arr2)
    val arr3 = Array(1,2,3,4,5,6,7,8,9,0)
    println(arr3)
  }
}
