package com.aura.spark.spark.p1;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.VoidFunction;
import scala.Tuple2;

import java.util.Arrays;

/**
 * java lambda表达式初体验
 */
public class LambdaSparkWordCountOps {
    public static void main(String[] args) {
        //step 1、创建编程入口类
        SparkConf conf = new SparkConf();
        conf.setMaster("local[*]");
        conf.setAppName(LambdaSparkWordCountOps.class.getSimpleName());

        JavaSparkContext jsc = new JavaSparkContext(conf);

        //step 2、加载外部数据 形成spark中的计算的编程模型RDD
        JavaRDD<String> linesRDD = jsc.textFile("F:/hello.txt");
        linesRDD.foreach(new VoidFunction<String>() {
            @Override
            public void call(String s) throws Exception {
                System.out.println(s);
            }
        });
        // step 3、对加载的数据进行各种业务逻辑操作---转换操作transformation
        System.out.println("==========经过拆分之后的RDD数据=================");
        JavaRDD<String> wordsRDD = linesRDD.flatMap(line -> Arrays.asList(line.split("\\s+")).iterator());
        wordsRDD.foreach(new VoidFunction<String>() {
            @Override
            public void call(String s) throws Exception {
                System.out.println(s);
            }
        });
        System.out.println("===============word拼接成键值对=================");
        JavaPairRDD<String, Integer> pairsRDD = wordsRDD.mapToPair(word -> new Tuple2<>(word, 1));
        pairsRDD.foreach(new VoidFunction<Tuple2<String, Integer>>() {
            @Override
            public void call(Tuple2<String, Integer> t) throws Exception {
                System.out.println(t._1 + "====" + t._2);
            }
        });
        System.out.println("================按照相同的key，统计value的值=================");
        JavaPairRDD<String, Integer> retRDD = pairsRDD.reduceByKey((v1, v2) -> v1 + v2);
        retRDD.foreach(t -> System.out.println(t._1 + "=" +t._2));
    }
}
