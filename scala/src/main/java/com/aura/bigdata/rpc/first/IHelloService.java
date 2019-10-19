package com.aura.bigdata.rpc.first;

import org.apache.hadoop.ipc.VersionedProtocol;

/*
    通信的服务接口协议
    VersionedProtocol:是一个服务版本的标识接口
 */
public interface IHelloService extends VersionedProtocol {
    long versionID = 1234567890L;

    boolean regist(String registCmd);

    String heartBeat(String hbCmd);
}
