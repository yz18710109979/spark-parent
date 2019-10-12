package com.aura.spark.p1

import org.apache.log4j.{Level, Logger}
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * scala版本的spark初体验
  */
object ScalaSparkWordCountOps {

  def main(args: Array[String]): Unit = {
    //日志级别打印设置
    Logger.getLogger("org.apache.hadoop").setLevel(Level.WARN);
    Logger.getLogger("org.apache.spark").setLevel(Level.WARN);
    Logger.getLogger("org.spark_project").setLevel(Level.INFO);
    val  conf = new SparkConf()
                    .setMaster("local[*]")
                    .setAppName("SparkWordCount")
    val sc = new SparkContext(conf)
    //load data
    val linesRDD:RDD[String] = sc.textFile("C:/Users/Administrator/Desktop/历史告警HBASE-8月.xlsx")
    //ops
//    val wordRDD:RDD[String] = linesRDD.flatMap(line => line.split("\\s+"))
//
//    val pairsRDD:RDD[(String,Int)] = wordRDD.map(word => (word,1));
//
//    val ret = pairsRDD.reduceByKey((v1,v2) => v1 + v2)
//
//    ret.foreach(t => println(t._1 + "----" + t._2))

    val ret = linesRDD.flatMap(_.split("\\s+")).map((_, 1)).reduceByKey(_ + _)
    //模式匹配--->元组、数组、list
    //        ret.foreach(t => {
    //            t match {
    //                case (word, count) => {
    //                    println(word + "---" + count)
    //                }
    //                case _ => {
    //                    println("fadfadfsadf")
    //                }
    //            }
    //        })

    ret.foreach{case (word, count) => println(word + "---" + count)}

    sc.stop()
  }
}
