package com.aura.bigdata.p7.akka.first

import akka.actor.{ActorRef, ActorSystem, Props}
import com.desheng.bigdata.p7.akka.Request

object StudentActorApp {
    def main(args: Array[String]): Unit = {
        //创建的actor的管理器 actorSystem
        val actorSystem = ActorSystem.create("student-actor-system")
        //创建进行事件操作的actor代理对象
        val teacherActorRef:ActorRef = actorSystem.actorOf(Props[TeacherActor], "teacherActor")
        //发送消息
        teacherActorRef ! Request("这道题太难了，我不会做！bgm，一剪梅走起了~")
        //关闭资源
        Thread.sleep(2000)
        actorSystem.shutdown()
    }
}
