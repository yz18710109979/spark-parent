package com.aura.spark.p1

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * scala版本的spark初体验
  */
object ScalaSparkWordCountOps {

  def main(args: Array[String]): Unit = {
    val  conf = new SparkConf()
                    .setMaster("local[*]")
                    .setAppName("SparkWordCount")
    val sc = new SparkContext(conf)
    //load data
    val linesRDD:RDD[String] = sc.textFile("F:/hello.txt")
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
