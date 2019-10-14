package com.aura.bigdata.proxy.statics;

public class Singer implements ISinger{
    private String name;

    public Singer(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println(name + "在热情高亢的卖命演唱~");
    }
}
