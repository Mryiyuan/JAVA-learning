package com.collection.study;

import jdk.nashorn.internal.parser.JSONParser;
import sun.awt.geom.AreaOp;
import java.util.ArrayList;
import java.util.Collection;

import java.util.ArrayList;

import static java.lang.System.*;

public class CollectionDemo01 {
    public static void  main (String[] args){
        Collection<String> c = new ArrayList<String>();
        c.add("hello");
        c.add("world");
        c.add("java");

        System.out.println(c);

        Generic<String> g1 = new Generic<String>();
        g1.setT("林青霞");
        System.out.println(g1.getT());

        Generic<Integer> g2 = new Generic<Integer>();
        g2.setT(2);
        System.out.println(g2.getT());

        Generic<Boolean> g3 = new Generic<Boolean>();
        g3.setT(true);
        System.out.println(g3.getT());

    }


}

//泛型类的使用和设置
class Generic<T>{
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}

