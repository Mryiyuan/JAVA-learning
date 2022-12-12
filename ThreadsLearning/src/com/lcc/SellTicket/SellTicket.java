package com.lcc.SellTicket;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author
 * \* @date: 2022/12/12
 * \* @time: 15:09
 * \* Description: 使用多线程模拟售票一百张 runnable,继承thread 都会超卖
 * \
 */
public class SellTicket {
    public static void main(String[] args) {
//        SellTicket01 sellTicket01 = new SellTicket01();
//        SellTicket01 sellTicket02 = new SellTicket01();
//        SellTicket01 sellTicket03 = new SellTicket01();
//
//        sellTicket01.start();
//        sellTicket02.start();
//        sellTicket03.start();
        SellTicket02 sellTicket02 = new SellTicket02();
        new Thread(sellTicket02).start();
        new Thread(sellTicket02).start();
        new Thread(sellTicket02).start();


    }
}

//使用Threads
class SellTicket01 extends Thread {
    public static int ticketnum = 100;//让多个线程共享ticketnum

    @Override
    public void run() {

        while (true) {
            if (ticketnum <= 0) {
                System.out.println("售票结束");
                break;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票" + "剩余票数:" + (--ticketnum));

        }
    }
}

class SellTicket02 implements Runnable {
    public int ticketnum = 100;//让多个线程共享ticketnum

    @Override
    public void run() {
        while (true) {
            if (ticketnum <= 0) {
                System.out.println("售票结束");
                break;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票" + "剩余票数:" + (--ticketnum));

        }


    }
}
