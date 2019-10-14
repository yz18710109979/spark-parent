package com.aura.bigdata.proxy.dynimac;

import com.aura.bigdata.proxy.statics.ISinger;
import com.aura.bigdata.proxy.statics.Singer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//动态代理
public class DynimcProxyApp {
    public static void main(String[] args) {
        final Singer singer = new Singer("cxks");
        ISinger o = (ISinger)Proxy.newProxyInstance(
                Singer.class.getClassLoader(),
                Singer.class.getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("出场费地域6位数面谈~~~~");
                        Object result = method.invoke(singer, args);
                        System.out.println("抽成20%~~~~");
                        return result;
                    }
                }
        );
        o.show();
    }
}
