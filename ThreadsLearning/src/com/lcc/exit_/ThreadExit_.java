package com.lcc.exit_;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author
 * \* @date: 2022/12/12
 * \* @time: 15:43
 * \* Description: 线程终止
 * \
 */
public class ThreadExit_ {
    public static void main(String[] args) throws InterruptedException {
        //如果我希望main线程控制T中断 我需要修改loop
        T t = new T();
        t.start();
        Thread.sleep(5000);
        t.setloop(false);
    }
}
class T extends Thread{
    private int n = 100;
    private boolean loop  = true;
    @Override
    public void run() {
        while (loop) {

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread is still running");

        }
    }

    public void setloop(boolean loop){
        this.loop = loop;
    }
}