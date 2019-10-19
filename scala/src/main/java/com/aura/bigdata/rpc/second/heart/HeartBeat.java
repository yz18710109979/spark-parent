package com.aura.bigdata.rpc.second.heart;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class HeartBeat implements Writable {
    private String cmd;
    private String time;
    private String id;

    public void write(DataOutput out) throws IOException {
        out.writeUTF(cmd);
        out.writeUTF(time);
        out.writeUTF(id);
    }

    public void readFields(DataInput in) throws IOException {
        this.cmd = in.readUTF();
        this.time = in.readUTF();
        this.id = in.readUTF();
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
