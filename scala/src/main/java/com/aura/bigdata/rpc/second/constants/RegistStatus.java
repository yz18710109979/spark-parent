package com.aura.bigdata.rpc.second.constants;

public enum RegistStatus {

    OK(2000, "成功"),
    SERVER_EXISTS(4040, "dataNode已经存在"),
    SERVER_EXCEPTION(5050, "服务端内部异常");

    public int status;

    public String reason;
    private RegistStatus(int status, String reason) {
        this.status = status;
        this.reason = reason;
    }

}
