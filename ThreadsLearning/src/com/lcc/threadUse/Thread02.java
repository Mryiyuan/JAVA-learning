package com.lcc.threadUse;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author LCC
 * \* @date: 2022/12/12
 * \* @time: 14:03
 * \* Description:
 * \
 */
public class Thread02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        //dog,start()这里不能调用start（）
        //创建了Thread对象，把dog对象（实现了runnable），放入thread
        Thread thread = new Thread(dog);
        thread.start();

    }
}

class Dog implements Runnable {//通过实现runnable方法，开发线程

    @Override
    public void run() {
        int count = 0;
        while (true) {
            System.out.println("小狗汪汪叫" + (++count) + Thread.currentThread().getName());
            //休眠一秒
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(count==10){
                break;
            }
        }

    }
}