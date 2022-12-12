package com.lcc.threadUse;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author
 * \* @date: 2022/12/12
 * \* @time: 14:42
 * \* Description:
 * \
 */
public class Thread03 {
    public static void main(String args[]){
        TH t1 = new TH();
        TH t2 = new TH();
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        thread1.start();
        thread2.start();
        System.out.println("main thread continue");



    }
}
class TH implements Runnable{
    int n = 0;
    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("hello" + (++n));
            if (n == 20) {
                break;
            }
        }
    }
}