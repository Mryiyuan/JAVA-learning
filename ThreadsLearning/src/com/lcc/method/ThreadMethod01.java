package com.lcc.method;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author
 * \* @date: 2022/12/12
 * \* @time: 16:08
 * \* Description:
 * \
 */
public class ThreadMethod01 {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.setName("lcc");
        t.setPriority(Thread.MIN_PRIORITY);
        t.start();
//        System.out.println(t.getName());

        for(int i=0;i<5;i++){
            Thread.sleep(1000);
            System.out.println("hi"+i);
        }


        System.out.println(t.getName()+" 线程的优先级 = "+t.getPriority());
        t.interrupt();//当执行到这里，就会中断t线程的休眠

    }
}

class T extends Thread {
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "吃包子~~~~~~" + i);
            }
            try {
                System.out.println(Thread.currentThread().getName() + "休眠中");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "被interrupt了");
            }
        }
    }
}