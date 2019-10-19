package com.aura.bigdata.rpc.second;

import com.aura.bigdata.rpc.second.heart.HeartBeat;
import com.aura.bigdata.rpc.second.heart.HeartBeatResult;
import com.aura.bigdata.rpc.second.regist.DataNodeInfo;
import com.aura.bigdata.rpc.second.regist.RegistResult;
import org.apache.hadoop.ipc.VersionedProtocol;

public interface IHelloService extends VersionedProtocol {
    long versionID = 9876543210L;
    RegistResult regist(DataNodeInfo dataNodeInfo);

    HeartBeatResult heartBeat(HeartBeat heartBeat);
}
