package com.aura.bigdata.p7.actor

import scala.actors.Actor

/**
  * scala actor基于case class的单向通信
  */
object _02ActorOps {
    def main(args: Array[String]): Unit = {
        val greetActor = new GreetingActor
        greetActor.start()
        //发送线程消息
        greetActor ! GoodMorning("how are you, 吕保全？ i'm fine, and you?")
        greetActor ! MonringMeeting("昨天下了一场大暴雨，奴家被淋湿，然后感冒了~")

    }
}

case class GoodMorning(hello:String)

case class MonringMeeting(content:String)

class GreetingActor extends Actor {
    override def act(): Unit = {
        while (true) {
            receive {//接收的意思 有阻塞，没有消息发送就会blocking
                case GoodMorning(hello) => {
                    println(hello)
                }
                case MonringMeeting(content) => {
                    println(s"Let's talk about sth. with: " + content)
                }
            }
        }
    }
}