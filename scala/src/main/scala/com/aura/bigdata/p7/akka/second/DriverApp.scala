package com.aura.bigdata.p7.akka.second

import akka.actor.{ActorSystem, Props}
import com.aura.bigdata.p7.akka.Signal

object DriverApp {
    def main(args: Array[String]): Unit = {
        val actorSystem = ActorSystem.create("teacher-student-actor-system")

        val teacherActorRef = actorSystem.actorOf(Props[TeacherActor], "teacherActor")//创建的actor名称在同一个actorSystem中不可重复

        val stuActorRef = actorSystem.actorOf(Props(classOf[StudentActor], teacherActorRef), "studentActor")

        //发送事件
        stuActorRef ! Signal

        Thread.sleep(2000)
        actorSystem.shutdown()
    }
}
