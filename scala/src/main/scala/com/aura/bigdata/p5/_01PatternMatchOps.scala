package com.aura.bigdata.p5

import java.io.FileNotFoundException

import scala.io.{Source, StdIn}

//scala模式匹配操作
object _01PatternMatchOps {
  def main(args: Array[String]): Unit = {
    //        matchOps1
    //        matchOps2
    //        matchOps3
    //        matchOps4
    //        matchOps5
    //        matchOps6
    //        matchOps7
    //        matchOps8
    matchOps9
  }
  def matchOps9: Unit = {

    sealed abstract class TrafficLightColor

    case object GREEN extends TrafficLightColor
    case object YELLOW extends TrafficLightColor
    case object RED extends TrafficLightColor

    def tips(light:TrafficLightColor): Unit = {
      light match {
        case RED => println("行车不规范，亲人两行泪")
        case YELLOW => println(
          "骑摩托车的请带好头盔，否则让开宝马车的同学看见，略显感概"
        )
        case GREEN => println("开车不喝酒，喝酒不开车，还要远离女司机~")
      }
    }
    tips(GREEN)
  }

  def matchOps8: Unit = {
    val capitals = Map(
      "France" -> "Paris",
      "Japan" -> "Tokyo Hot",
      "Russia" -> "Moscow"
    )

    val capital:Option[String] = capitals.get("Russia")
    capital match {
      case Some(city) => println(city)
      case None => println("这个真没有~")
    }

    println( capitals.getOrElse("India", "爪哇岛"))
  }

  /**
    * 一次性输入三个值，
    * 三个表达式：left  中  →
    * 用，隔开
    */
  def matchOps7(): Unit = {

    case class Expression(left:Double, opeator:String, right:Double)

    val line = StdIn.readLine("四则运算表达式:")
    val fields = line.split(",")
    val left = fields(0).trim.toDouble
    val operator = fields(1).trim
    val right = fields(2).trim.toDouble

    val expr = Expression(left, operator, right)

    val ret = expr match {
      case Expression(left, "+", right) => left + right
      case Expression(left, "-", right) => left - right
      case Expression(left, "/", right) => left / right
      case Expression(left, "*", right) => left * right
    }
    println("ret = " + ret)
  }

  def matchOps6: Unit = {

    abstract class Expr

    case class Var(name:String) extends Expr

    case class UnOp(operator:String, expr:Expr) extends Expr

    case class BinOp(left:Expr, operator:String, right:Expr) extends Expr

    def caseClassOps(expr:Expr) = {
      expr match {
        case Var(name) => println("Var: " + name)
        case UnOp("+", Var(name)) => println("UnOp: " + name + "+")
        case BinOp(Var(left), "-", Var(right)) => println("BinOp => " + (left.toInt - right.toInt))
        case _ => println("去死吧~")
      }
    }
    caseClassOps(BinOp(Var("1"), "-", Var("101")))
  }

  def matchOps5: Unit = {
    val array = Array(-1, 1, 0)
    array match {
      //            case Array(x, y) => {//匹配当前数组长度为2
      //                println(s"x:$x, y: $y")
      //            }
      case Array(-1, _ *) => {//匹配当前数组的第一个元素为-1，长度不限
        println(array.mkString("[", ", ", "]"))
      }
    }
  }
  def matchOps4: Unit = {
    def typeOps(x:Any): Unit = {
      val ret = x match {
        case i:Int => i
        case str:String => str.toUpperCase()
        case z:scala.math.BigInt => Int.MaxValue
        case c:Char => c.toInt
        case _ => 0
      }
      println("ret: " + ret)
    }

    typeOps(1)
    typeOps("abcefg")
    typeOps('a')
  }
  //
  def matchOps3 : Unit = {
    try{
//      val lines = Source.fromFile("ffff")
//      val i = 1/0
      throw new RuntimeException
    }catch {
      case fnfe : FileNotFoundException => {
        println("fnfe: " + fnfe.getMessage)
      }
      case ar:ArithmeticException => {
        println("arch: " + ar.getMessage)
      }
      case _ => {
        println("default")
      }
    }
    println("===============================")
    "Hello, world" foreach { c => println (
      c match {
        case ' ' => "space"
        case ch => "Char: " + ch
      }
    )}
  }
  //守卫 yield
  def matchOps2 : Unit = {
    val list = 1 to 10
    val ret = for (i <- list if 1 % 2 ==0 ) yield {i}
    println(ret)
    val res = if (list.isEmpty) "heihei" else "haha"
    println(res)
  }
  /*
        使用模式匹配模拟java中的switch-case语法结构
        在控制台输入一个简单四则运算表达式，并进行求解
        比如：2 + 1 => 3

        在使用模式匹配的时候，如果没有对所有的可能性进行匹配的话，会报错，scala.MatchError
  */
  def matchOps1 : Unit = {
    println("四则运算表达式")
    println("左侧表达式：")
    val left = StdIn.readInt()
    println("操作符表达式：")
    val operator = StdIn.readChar()
    println("右侧表达式：")
    val right = StdIn.readInt()

    val res = operator match {
      case '+' => left + right
      case '-' => left - right
      case '*' => left * right
      case '/' => left /right
      //相当于java中的default，对其余可能性的匹配处理
      case _ => left % right
    }
    println(s"res = ${res}")
  }
}
