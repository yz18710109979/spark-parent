package com.aura.bigdata.rpc.second.regist;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class RegistResult implements Writable {
    //2000 注册成功
    //4040 注册失败：dataNode已经存在
    //5050 注册失败：服务器异常
    private int status;

    private String reason;

    public void write(DataOutput out) throws IOException {
        out.writeInt(status);
        out.writeUTF(reason);
    }

    public void readFields(DataInput in) throws IOException {
        this.status = in.readInt();
        this.reason = in.readUTF();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
