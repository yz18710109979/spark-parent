package com.aura.bigdata.proxy.generic;

import com.aura.bigdata.p4.funcs.Person;

import java.util.ArrayList;
import java.util.List;

public class GenericOps {

    public static void main(String[] args) {
        List list = new ArrayList();
//        list.add(1);
//        list.add("1");
        list.add(new Person("zs",12));
        for (Object o : list) {
            Person p = (Person)o;
            System.out.println(p.name() + "-->" + p.age());
        }
    }
}
