package com.aura.bigdata.p7.akka

sealed class Message

case object Signal extends Message
case class Request(req:String) extends Message
case class Response(resp:String) extends Message
