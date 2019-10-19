package com.aura.bigdata.p4.funcs
import scala.collection.mutable
object _05SetOps {
  def main(args: Array[String]): Unit = {
    val ts = mutable.SortedSet[Person]()(new Ordering[Person](){
      override def compare(x: Person, y: Person) = {
        var ret = y.age.compareTo(x.age)
        if(ret == 0) {
          ret = x.name.compareTo(y.name)
        }
        ret
      }
    })
    /**
      * 直接添加普通的不具备比较性的对象，会报错，
      * 要想完成比较，要么让元素具备比较性，要么让容器提供比较器
      *     在java中让元素具备比较性，就是让元素对应的class 实现Comparable比较接口
      *             在scala中让元素具备比较性，就让该元素扩展Ordered的比较接口
      *     在java中让容器具备比较性，就给容器提供一个Comparator比较器
      *         在scala中让容器具备比较性，就给容器提供一个Ordering的比较接口
      *     其实Ordered就是扩展了java中Comparable
      *     其实Ordering就是扩展了java中Comparator
      */
    ts.add(new Person("zhangsan",13))
    ts.add(new Person("lisi", 14))
    ts.add(new Person("wangermazi", 15))
    ts.add(new Person("zhaoliu", 16))
    ts.add(new Person("wang蕾蕾", 16))
    ts.foreach(println)
  }
}

class Person extends Ordered[Person]{
  var name : String = _
  var age : Int = _
  def this(name : String,age : Int) {
    this
    this.name = name
    this.age = age
  }
  override def compare(that: Person): Int = {
    var ret = this.age.compareTo(that.age)
    if(ret == 0 ) {
      ret = that.name.compareTo(this.name)
    }
    ret
  }
}