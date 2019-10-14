package com.aura.bigdata.proxy.statics;

public class ShowProcess {
    public static void main(String[] args) {
        Singer singer = new Singer("cxk");
        SingerAgent sa = new SingerAgent(singer);
        sa.show();
    }
}
