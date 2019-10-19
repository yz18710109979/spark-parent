package com.aura.bigdata.rpc.first;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;

//作为rpc的服务端，提供服务
public class MyNameNode {
    public static void main(String[] args) throws IOException {
        //启动一个NameNode的rpc进程，通过rpc.builder
        Configuration conf = new Configuration();
        RPC.Builder builder = new RPC.Builder(conf);

        RPC.Server server = builder
                .setProtocol(IHelloService.class)//服务端和客户端通信的标准规范
                .setInstance(new HelloServiceImpl())//协议的动作具体的承担着
                .setBindAddress("127.0.0.1")
                .setPort(6789)
                .build();
        server.start();
        System.out.println("MyNameNode rpc server is started~");
    }
}
