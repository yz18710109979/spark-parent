package com.aura.bigdata.rpc.second.regist;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Objects;

public class DataNodeInfo implements Writable {
    private String host;
    private int port;
    //datanode-host:port-timestamp(yyyyMMddHHmmss)
    private String id;
    private int disk;
    private int core;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDisk() {
        return disk;
    }

    public void setDisk(int disk) {
        this.disk = disk;
    }

    public int getCore() {
        return core;
    }

    public void setCore(int core) {
        this.core = core;
    }

    public void write(DataOutput out) throws IOException {
        out.writeUTF(this.host);
        out.writeInt(this.port);
        out.writeUTF(this.id);
        out.writeInt(this.disk);
        out.writeInt(this.core);
    }

    public void readFields(DataInput in) throws IOException {
        this.host = in.readUTF();
        this.port = in.readInt();
        this.id = in.readUTF();
        this.disk = in.readInt();
        this.core = in.readInt();
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataNodeInfo that = (DataNodeInfo) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return 11;
    }
}
