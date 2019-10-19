package com.aura.bigdata.p7.akka.second

import akka.actor.{Actor, ActorLogging}
import com.desheng.bigdata.p7.akka.{Request, Response}

class TeacherActor extends Actor with ActorLogging {
    override def receive = {
        case Request(req) => {
            log.info("学生问的问题是：{}", req)
            //老师向学生回复 该sender对象就代表的是该条Request事件的发送者
            sender ! Response("因为局部变量的声明周期太短，弹栈之后会造成对象引用的内存泄露~")
        }
    }
}
