package com.aura.bigdata.p7.akka.second

import akka.actor.{Actor, ActorLogging, ActorRef}
import com.aura.bigdata.p7.actor.Response
import com.aura.bigdata.p7.akka.{Request, Signal}

class StudentActor(teacherActorRef: ActorRef) extends Actor with ActorLogging {
    override def receive = {
        case Signal => {
            log.info("老师准备就绪，大家可以问问题了~")
            //向老师问问题
            teacherActorRef ! Request("为什么匿名内部类中访问局部变量，该变量要被final修饰")
        }
        case Response(resp) => {
            log.info("老师回复说：" + resp)
        }
    }
}
