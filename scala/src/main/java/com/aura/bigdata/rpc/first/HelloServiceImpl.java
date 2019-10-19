package com.aura.bigdata.rpc.first;

import org.apache.hadoop.ipc.ProtocolSignature;

import java.io.IOException;

public class HelloServiceImpl implements IHelloService {
    public boolean regist(String registCmd) {
        System.out.println("客户端发送的注册消息：" + registCmd);
        if(registCmd.equalsIgnoreCase("regist"))
            return true;
        return false;
    }

    public String heartBeat(String hbCmd) {
        System.out.println("客户端发送的心跳消息：" + hbCmd);
        return "ok";
    }

    public long getProtocolVersion(String protocol, long clientVersion) throws IOException {
        return versionID;
    }

    public ProtocolSignature getProtocolSignature(String protocol, long clientVersion, int clientMethodsHash) throws IOException {
        return new ProtocolSignature();
    }
}
