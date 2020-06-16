package com.obtk.lock;

import java.util.concurrent.locks.ReentrantLock;
/**
 *
 * Lock和Synchonized的异同
 */
class Window implements  Runnable{
    private  int ticket=100;
    //实例化一个ReentrantLock
    private ReentrantLock a=new ReentrantLock();
    @Override
    public synchronized void run() {
        while (true){

            try {
                //2.调用锁定方法lock()
                a.lock();
                if (ticket > 0) {

                    System.out.println(Thread.currentThread().getName() + "售票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                //3.调用解锁的方法
                a.unlock();
            }

        }
    }
}

public class LockTest {
    public static void main(String[] args) {
        Window window=new Window();

        new Thread(window).start();
        new Thread(window).start();
        new Thread(window).start();

    }
}
