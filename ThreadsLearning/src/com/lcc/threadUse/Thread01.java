package com.lcc.threadUse;

public class Thread01 {
    public static void main(String[] args) {
//创建一个cat对象，可以当线程使用
        Cat cat = new Cat();
        cat.start();
        //说明：当main线程启动一个子线程Thread-0,主线程不会阻塞，会继续执行

    }

}

//1. 当一个类继承了Thread类，该类就可以当做线程使用
//2.我们会重写run方法，写上自己的code
//3.run Thread 类实现了Runnable接口的run方法
class Cat extends Thread {
    @Override
    public void run() {
        int times = 0;
        while (true) {
            //间隔1s输出
            System.out.println("I am cat " + (++times) + " Thread name = " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(times==80){
                break;
            }
        }
    }
}

