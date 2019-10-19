package com.aura.bigdata.p6

import java.io.File

import scala.io.Source
object MyImplicits {
  implicit def double2String(d:Double):String = d.toString
  implicit def str2Double(str:String):Double = str.length.toDouble

  implicit def file2RichFile(file:File):RichFile = new RichFile(file)
}
class RichFile(file:File) {
  def read():String = {
    Source.fromFile(file).mkString
  }
}
