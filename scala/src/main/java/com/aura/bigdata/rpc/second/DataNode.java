package com.aura.bigdata.rpc.second;

import com.aura.bigdata.rpc.second.constants.RegistStatus;
import com.aura.bigdata.rpc.second.heart.HeartBeat;
import com.aura.bigdata.rpc.second.heart.HeartBeatResult;
import com.aura.bigdata.rpc.second.regist.DataNodeInfo;
import com.aura.bigdata.rpc.second.regist.RegistResult;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class DataNode {
    static Random random = new Random();
    static String cmds[] = {
            "人生自古谁无死，早死晚死都得死",
            "人固有一死，或重于泰山，或轻如鸿毛",
            "但悲不见九州同，家祭无忘告乃翁",
            "若为自由故，二者皆可抛"
    };
    public static void main(String[] args) throws IOException, InterruptedException {
        final DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        final IHelloService ihs = RPC.getProxy(IHelloService.class,
                IHelloService.versionID,
                new InetSocketAddress("127.0.0.1", 9876),
                new Configuration());
        final DataNodeInfo dnInfo = new DataNodeInfo();
        dnInfo.setHost("111.111.111.111");
        dnInfo.setPort(50010);
        dnInfo.setCore(4);
        dnInfo.setDisk(1000);
        String id = "datanode-" + dnInfo.getHost() + ":" + dnInfo.getPort() + "-" + df.format(new Date());
        id = "datanode-111.111.111.111:50010-20190909165315";
        dnInfo.setId(id);
        RegistResult registResult = ihs.regist(dnInfo);
        while (registResult.getStatus() != RegistStatus.OK.status) {
            System.out.println("注册失败，失败原因：" + registResult.getReason());
            Thread.sleep(3000);
            registResult = ihs.regist(dnInfo);
        }
        //注册成功
        //注册成功
        System.out.println("datanode: " + dnInfo.getId() + ", 注册NameNode成功！");
            /*
                发起心跳，每隔一定时间发送一条命令--->定时器
                在jdk中有两种方式发送定时消息
                    Timer类来完成
                    线程池调度Executors来完成定时调度
             */
        Timer time = new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                //线程中向服务端nameNode发起心跳
                HeartBeat heartBeat = new HeartBeat();
                heartBeat.setId(dnInfo.getId());
                heartBeat.setTime(df.format(new Date()));
                heartBeat.setCmd(cmds[random.nextInt(cmds.length)]);
                HeartBeatResult beatResult = ihs.heartBeat(heartBeat);
                System.out.println("服务端返回的心跳消息" + beatResult.getStatus() + ", " + beatResult.getDescription());
            }
        }, 2000,2000);//延迟2s开始心跳，心跳间隔为2s
    }
}
