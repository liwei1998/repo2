package com.obtk.test;

/**
 * 例子：创建三个窗口去卖票，总数为100张,使用Runnable的方式实现
 *
 * 存在线程的安全问题
 */

class Window02 implements Runnable{

    private  int ticket=100;

    @Override
    public void run() {
        while (true){
            if (ticket>0){
                System.out.println(Thread.currentThread().getName()+"  "+ticket);
                ticket--;
            }else{
                break;

            }
        }
    }
}


public class WindowTest02 {
    public static void main(String[] args) {
        //为什么不用加static也只有一百张票，是因为我们只创建了一个对象，只是多开了几个线程
        //相当于几个线程共享了一个对象
            Window02 test=new Window02();
            new Thread(test).start();
            new Thread(test).start();
            new Thread(test).start();
    }
}

