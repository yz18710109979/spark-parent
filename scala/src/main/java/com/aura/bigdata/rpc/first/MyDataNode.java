package com.aura.bigdata.rpc.first;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/*
    客户端进程信息
    要完成，在服务端的注册和心跳，而这些方法都是服务端的，是另外一个进程，
    所以为了完成上述操作，我们调用服务端，就要想在本地调用这些api一样
    所以就需要在datanode中得到一个namenode的代理对象
    通过rpc.getProxy获得服务的代理对象

    在客户端执行的时候发生异常：
        java.lang.RuntimeException: java.lang.NoSuchFieldException: versionID
 */
public class MyDataNode {

    static String[] heartBeatStrs = {
            "行车不规范，亲人两行泪",
            "少壮不努力，长大抢小米",
            "不忘初心，方得始终",
            "初心易得，始终难守"
    };
    static Random random = new Random();
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        /**
         * @param protocol
         * @param clientVersion
         * @param addr
         * @param conf
         * @return a proxy instance 返回的就是MyNameNode的代理对象
         */
        final IHelloService hs = RPC.getProxy(
                IHelloService.class,
                IHelloService.versionID,
                new InetSocketAddress("127.0.0.1", 6789),//服务端的host和port
                conf);
        System.out.println("客户端启动，等待向服务端发送注册和心跳");
        Thread.sleep(1000);
        if(hs.regist("regist")) {
            System.out.println("注册成功~~~~");
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    String ret = hs.heartBeat(heartBeatStrs[random.nextInt(heartBeatStrs.length)]);
                    System.out.println("服务端返回的心跳消息：" + ret);
                }
            }, 5000, 2000);
        }
    }
}
