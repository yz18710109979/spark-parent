package com.aura.spark.spark.p1;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.function.VoidFunction;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 通过本案例来做入门程序
 *
 */
public class JavaSparkWordCountOps {
    public static void main(String[] args) {
        //step 1、创建编程入口类
        SparkConf conf = new SparkConf();
        conf.setMaster("local[*]");
        conf.setAppName(JavaSparkWordCountOps.class.getSimpleName());

        JavaSparkContext jsc = new JavaSparkContext(conf);
        //step 2、加载外部数据 形成spark中的计算的编程模型RDD
        JavaRDD<String>  linesRDD = jsc.textFile("C:/shouxinBuildWord/tmp_success.log");

        // step 3、对加载的数据进行各种业务逻辑操作---转换操作transformation
        JavaRDD<String> wordsRDD = linesRDD.flatMap(new FlatMapFunction<String, String>() {
            public Iterator<String> call(String line) throws Exception {
                return Arrays.asList(line.split(":")).iterator();
            }
        });
        System.out.println("======经过拆分之后的rdd数据========");
        JavaPairRDD<String, Integer> pairsRDD = wordsRDD.mapToPair(new PairFunction<String, String, Integer>() {
            public Tuple2<String, Integer> call(String word) throws Exception {
                return new Tuple2<String, Integer>(word, 1);
            }
        });
        System.out.println("======word拼装成键值对===========");
        JavaPairRDD<String, Integer> retRDD = pairsRDD.reduceByKey(new Function2<Integer, Integer, Integer>() {
            public Integer call(Integer v1, Integer v2) throws Exception {
                //int i = 1 / 0;//印证出这些转换的transformation算子是懒加载的，需要action的触发
                return v1 + v2;
            }
        });
        System.out.println("------按照相同的key，统计value--------------");
        retRDD.foreach(new VoidFunction<Tuple2<String, Integer>>() {
            public void call(Tuple2<String, Integer> t) throws Exception {
                System.out.println(t._1 + "---->" + t._2);
            }
        });
    }
}
