package com.aura.bigdata.rpc.second;

import com.desheng.bigdata.rpc.second.constants.RegistStatus;
import com.desheng.bigdata.rpc.second.heart.HeartBeat;
import com.desheng.bigdata.rpc.second.heart.HeartBeatResult;
import com.desheng.bigdata.rpc.second.regist.DataNodeInfo;
import com.desheng.bigdata.rpc.second.regist.RegistResult;
import org.apache.hadoop.ipc.ProtocolSignature;

import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class HelloServiceImpl implements IHelloService {

    private Set<DataNodeInfo> dataNodes = new HashSet<>();

    private Random random = new Random();

    @Override
    public RegistResult regist(DataNodeInfo dataNodeInfo) {
        System.out.printf(
                "注册的dataNode信息>>> id:%s, host:%s, port:%d, disk:%d, core: %d\n",
                dataNodeInfo.getId(), dataNodeInfo.getHost(),
                dataNodeInfo.getPort(), dataNodeInfo.getDisk(),
                dataNodeInfo.getCore());
        RegistResult rr = new RegistResult();
        if(dataNodes.contains(dataNodeInfo)) {//服务器中已经有了当前的dataNode
            rr.setStatus(RegistStatus.SERVER_EXISTS.status);
            rr.setReason(RegistStatus.SERVER_EXISTS.reason);
            System.out.println("注册状态：" + RegistStatus.SERVER_EXISTS.reason);
            return rr;
        }
        try {
            /*
                模拟服务端的异常
                查看注册时长，如果服务端注册超过2s，任务服务端内部有问题，反之正常
             */
            long sleep = 1000 * random.nextInt(4);// 0 1 2 3
            Thread.sleep(sleep);
            if(sleep > 2000) {//休眠过程，认为服务器异常
                rr.setStatus(RegistStatus.SERVER_EXCEPTION.status);
                rr.setReason(RegistStatus.SERVER_EXCEPTION.reason);
            } else {
                rr.setStatus(RegistStatus.OK.status);
                rr.setReason(RegistStatus.OK.reason);
                dataNodes.add(dataNodeInfo);//注册，将dataNode信息保存在NameNode内部
            }
            System.out.println("注册状态：" + rr.getReason());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return rr;
    }

    @Override//主要目的，就是监测客户端和服务是否正常
    public HeartBeatResult heartBeat(HeartBeat heartBeat) {
        System.out.printf("客户端dataNode发送的心跳信息>>> id:%s, cmd: %s, time: %s\n", heartBeat.getId(), heartBeat.getCmd(), heartBeat.getTime());
        HeartBeatResult hbr = new HeartBeatResult();
        try {
            /*
                模拟服务端的心跳
                如果长时间服务端没有返回（5s），任务服务端和客户端之间的通信有问题
            */
            long sleep = 1000 * random.nextInt(8);// 0~7
            Thread.sleep(sleep);
            if(sleep > 5000) {
                hbr.setStatus(500);
                hbr.setDescription("客户端和服务端连接超时~");
            } else {
                hbr.setStatus(200);
                hbr.setDescription("ok~");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return hbr;
    }

    @Override
    public long getProtocolVersion(String protocol, long clientVersion) throws IOException {
        return versionID;
    }

    @Override
    public ProtocolSignature getProtocolSignature(String protocol, long clientVersion, int clientMethodsHash) throws IOException {
        return new ProtocolSignature();
    }
}
