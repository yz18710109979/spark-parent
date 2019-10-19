package com.aura.bigdata.rpc.second;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;

public class NameNode {
    public static void main(String[] args) throws IOException {
        Configuration conf = new Configuration();

        RPC.Builder builder = new RPC.Builder(conf);

        RPC.Server server = builder.setProtocol(IHelloService.class)
                       .setInstance(new HelloServiceImpl())
                       .setBindAddress("127.0.0.1")
                       .setPort(9876).build();
        server.start();
        System.out.println("server NameNode started! Listening addr: 127.0.0.1:9876");
    }
}
