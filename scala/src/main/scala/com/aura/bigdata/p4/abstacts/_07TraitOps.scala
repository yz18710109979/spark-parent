package com.aura.bigdata.p4.abstacts

import java.text.SimpleDateFormat
import java.util.Date

//特质
object _07TraitOps {
  def main(args: Array[String]): Unit = {
    val log : Log = new ConsoleLog
    val dsLog  = new DailyFileLog
    val msg = "org.apache.catalina.startup.Catalina.start Server startup in 1126 ms"
    log.log(msg)
    dsLog.log(msg)
    dsLog.serialize()
    println("---------------------------------")
    val cLog = new ConsoleLog with MySerializable
    cLog.serialize()
  }
}
//定义了一个特质
trait Log{
  def log(msg:String) : Unit
}

trait MySerializable{
  def serialize() : Unit = {
    println("进行类的序列化~~~")
  }
}
class DailyFileLog extends Log with MySerializable{
  override def log(msg: String): Unit = {
    val sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    println(s"daily file >>>>time: ${sdf.format(new Date())}>>>>" + msg)
  }
}
class ConsoleLog extends Log{
  def log(msg: String): Unit = {
    println("控制台：" + msg)
  }
}