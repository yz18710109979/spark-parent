package com.aura.bigdata.p6
//泛型
object _01GenericOps {
  def main(args: Array[String]): Unit = {
    //        genericMethod()
    genericBound()
  }
  def genericBound(): Unit = {

    def intSort[T <% Ordered[T]](arr:Array[T]) {
      for (i <- 0 until (arr.length - 1)) {
        for (j <- (i + 1) until arr.length) {
          if (arr(i).compareTo(arr(j)) > 0) {
            swap(arr, i, j)
          }
        }
      }
    }
    def swap[T](arr:Array[T], i:Int, j:Int) {
      val temp = arr(i)
      arr(i) = arr(j)
      arr(j) = temp
    }

    val arr = Array[Int](-3, 6, 0, 7, 1, -5, 2)
    System.out.println("排序前的数组arr：" + arr.mkString("[", ", ", "]"));
    intSort(arr)
    System.out.println("排序后的数组arr：" + arr.mkString("[", ", ", "]"));
  }
  //泛型函数
  def genericMethod(): Unit = {

    class Calc {
      def add(a:Int, b:Int): Double = {
        a + b
      }
      def add(a:Float, b:Float): Double = {
        a + b
      }
    }

    class MyCalc[T] {
      def add(a:T, b:T): Double = {
        a.toString.toDouble + b.toString.toDouble
      }
    }

    val calc = new Calc
    println(calc.add(1, 2))
    println(calc.add(1.0f, 2.0f))
    println("---------MyCalc[T]----------")
    val myCalc = new MyCalc[Int]
    println(myCalc.add(1, 2))
    val myFloatCalc = new MyCalc[Float]
    println(myFloatCalc.add(1.0f, 2.5f))
    println("-----------MyNewCalc----------")
    class MyNewCalc {
      def add[T](a:T, b:T): Double = {
        a.toString.toDouble + b.toString.toDouble
      }
    }

    val mnCalc = new MyNewCalc
    println(mnCalc.add[Int](1, 2))
    println(mnCalc.add(1.0f, 2.0f))
  }

  def genericClass : Unit ={
    class Student(first : String ,second : String){
      def show(): Unit ={
        println(first + "--------->" + second)
      }
    }
    class Student1(first : Int ,second : Int){
      def show(): Unit ={
        println(first + "--------->" + second)
      }
    }
    class Student2(first : Double ,second : Double){
      def show(): Unit ={
        println(first + "--------->" + second)
      }
    }
    class Student3(first : Any ,second : Any){
      def show(): Unit ={
        println(first + "--------->" + second)
      }
    }
    //定义泛型类
    class Student4[T](first : T ,second : T){
      def show(): Unit ={
        println(first + "--------->" + second)
      }
    }
    class Student5[T,S](first : T ,second : S){
      def show(): Unit ={
        println(first + "--------->" + second)
      }
    }
  }
}
