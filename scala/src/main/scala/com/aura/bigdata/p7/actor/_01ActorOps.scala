package com.aura.bigdata.p7.actor

import scala.actors.Actor

/**
  * scala actor通信案例之单项通信
  * 编程入口就是Actor的通信，就相当于java中的Runnable接口
  * 同样在完成一个Actor声明之后，需要覆盖其中的一个方法act方法
  */
object _01ActorOps {
    def main(args: Array[String]): Unit = {
        val helloActor = new HelloActor
        helloActor.start()
        //发送线程消息
        helloActor ! "你好"
        helloActor ! 3

    }
}

class HelloActor extends Actor {
    override def act(): Unit = {
        while (true) {
            receive {//接收的意思 有阻塞，没有消息发送就会blocking
                case str:String => {
                    println("str: " + str)
                }
                case i:Int => println(i)
            }
        }
    }
}