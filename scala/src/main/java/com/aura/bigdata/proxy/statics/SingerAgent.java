package com.aura.bigdata.proxy.statics;

public class SingerAgent {
    private Singer singer;

    public SingerAgent(Singer singer) {
        this.singer = singer;
    }

    public void show(){
        System.out.println("出场费地域6位数面谈~~~~");
        singer.show();
        System.out.println("抽成20%~~~~");
    }
}
