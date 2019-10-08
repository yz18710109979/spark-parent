package com.aura.spark.spark.p1;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;

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
        JavaRDD<String>  linesRDD = jsc.textFile("");
        linesRDD.flatMap(new FlatMapFunction<String, String>() {
            public Iterator<String> call(String line) throws Exception {
                return Arrays.asList(line.split("\\s+")).iterator();
            }
        });

    }
}
