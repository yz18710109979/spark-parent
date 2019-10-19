package com.aura.bigdata.rpc.second.heart;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class HeartBeatResult implements Writable {

    private int status;

    private String description;


    public void write(DataOutput out) throws IOException {
        out.writeInt(this.status);
        out.writeUTF(this.description);
    }

    public void readFields(DataInput in) throws IOException {
        this.status = in.readInt();
        this.description = in.readUTF();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
