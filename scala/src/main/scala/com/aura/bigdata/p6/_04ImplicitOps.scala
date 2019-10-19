package com.aura.bigdata.p6

import java.io.File

//通过隐式转换函数完成文件的读取
object _04ImplicitOps {
  def main(args: Array[String]): Unit = {
    import MyImplicits.file2RichFile
    val file = new File("E:/data/hello.txt")
    val ret = file.read
    println(ret)
  }
}
