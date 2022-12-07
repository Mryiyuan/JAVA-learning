package com.fanxing;

public class GenericImpl<T> implements Generic_Interface<T>{
    @Override
    public void show(T t) {
        System.out.println(t);
    }
}
