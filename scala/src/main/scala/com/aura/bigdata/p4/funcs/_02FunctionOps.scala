package com.aura.bigdata.p4.funcs
//常见的高阶函数
object _02FunctionOps {
  def main(args: Array[String]): Unit = {
    funOps
  }
  def funOps : Unit = {
    val array = Array(1,2,3,4,5)
    //filter(p:(src) => Boolean) 返回表达式结果为true的值
    val ret = array.filter((num : Int) => num % 2 == 0)
    println("filter的结果 : " + ret.mkString(","))//Arrays.toString(arr)
    println("filter结果：" + ret.mkString("[", ", ", "]"))

    //map(f:(src) => dest)
    //map函数的意思为：对集合中的每一个元素src，作用f匿名函数，生成一个新的元素dest
    //案例：将数组中的每一个元素变为原来的一半
    val dRet = array.map((num : Int) => num * 0.5)
    println("map结果：" + dRet.mkString("[",",","]"))

    //flatMap 是一个压平的操作flatMap(f:(src) => dest)
    //flatMap函数的意思为：对集合中的每一个元素src，作用f匿名函数，生成0个或者多个新的dest元素
    //案例：将一个字符串集合转化为一个字符集合
    println("------------flatMap-----------------")
    val strs = Array("hello world","green eye","green hand")
    val words : Array[String] = strs.flatMap((str : String) => str.split(" "))
    println("words : " + words.mkString("[",",","]"))
    //将这个字符串转化成字符的集合
    val chs : Array[Char] = strs.flatMap((str : String) => str.toCharArray)
    println("chs : " + chs.mkString("[",",","]"))

    //返回一个集合中元素的和，显然这个sum函数应该作用在一个类型为数字类型上的集合。
    println("------------sum,max,min-----------------")

    val arr = 1 to 100
    val sum = arr.sum
    println(s"sum = ${sum}")
    //同理，max、min都如sum一样
    println(s"max = ${arr.max}")
    println(s"min = ${arr.min}")

    //count(f:(src) => Boolean) 返回满足条件的元素个数
    println("------------count-----------------")
    //比如，获取集合中同时被3和5都整除的数的集合。
//    val cRet = arr.count((num : Int) => num % 3 == 0 && num % 5 == 0)
    val cRet = arr.count(_ % 15 ==0)
    println(s"cRet = ${cRet}")

    //foreach
    //foreach(func:(src) => Unit)遍历，或者是for遍历的另外一种方式，其中接收一个匿名函数作为参数，去处理遍历中的每一个元素。通常用该操作进行，比如数据库录入的操作。
    println("------------foreach----------------")
    words.foreach((word : String) => println(word))

    //reduce(func:(src1, scr2) => avgr)
    //reduce是一个聚合操作，对src1和src2进行聚合操作，返回值为avgr。需要注意的是，reduce操作聚合前和聚合后的数据类型必须要一直
    //案例：求一个数组的和。
    val reduceSum : Int = arr.reduce((num1 : Int,num2 : Int) =>{
      println(s"num1 = ${num1} , num2 = $num2")
      num1 + num2
    })
    println("reduceSum  :  " + reduceSum)

    //dropWhile(p:(src) => Boolean),从左向右删除集合中的元素，知道条件不满足，停下来。
    println("------------dropWhile----------------")
    val range = 1 to 10
    //1,2,3,4,5,6,7,8,9,10
    var newRange = range.dropWhile(_ < 3)
    println("dropWhile(num => num < 3): " + newRange)
    println("dropWhile(num => num != 3): " + range.dropWhile(_ != 3))
  }
}
