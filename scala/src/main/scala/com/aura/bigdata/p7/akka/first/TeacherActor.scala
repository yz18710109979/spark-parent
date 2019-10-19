package com.aura.bigdata.p7.akka.first

import akka.actor.Actor
import com.desheng.bigdata.p7.akka.Request

//创建一个teacher akka actor 接收学生的请求
class TeacherActor extends Actor {
    override def receive = {
        case Request(req) => {
            println("学生说： " + req)
        }
    }
}
