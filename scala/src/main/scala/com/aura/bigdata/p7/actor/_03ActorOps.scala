package com.aura.bigdata.p7.actor

import scala.actors.Actor

/**
  * scala actor基于case class的双向通信
  */
object _03ActorOps {
    def main(args: Array[String]): Unit = {
        val oldSong = new 老宋Actor
        val oldWang = new 老王Actor(oldSong)
        oldWang.start()
        oldSong.start()

        //old宋向old王打招呼
        oldWang ! Greeting("但使龙城飞将在")
    }
}

case class Greeting(greeting: String)
case class Response(resp:String)

class 老王Actor(oldSong: 老宋Actor) extends Actor {
    override def act(): Unit = {
        while(true) {
            receive {
                case Greeting(greeting) => {
                    println("老宋说：" + greeting)
                    oldSong ! Response("一树红杏出墙来")
                }
                case Response(resp) => {
                    println("老宋回：" + resp)

                }
            }
        }
    }
}

class 老宋Actor extends Actor {
    override def act(): Unit = {
        while(true) {
            receive {
                case Response(resp) => {
                    println("老王回：" + resp)
                    sender ! Response("千树万树梨花开")
                }
            }
        }
    }
}