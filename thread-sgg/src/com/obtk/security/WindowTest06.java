package com.obtk.security;

/**
 * 使用同步方法处理继承Thread类的方式中的线程安全问题
 */
class Window06 extends Thread{
    private  static  int ticket=100;

    static Object object=new Object();
    @Override
    public  void run() {
        while (true){
             show2();
        }
    }
    public static synchronized void show2(){//同步监视器：在这个方法声明中 表示Window06.class
        //public  synchronized void show2()  同步监视器：在这个方法声明中 表示test1，test2，test3，
        // 即表示不是同一把锁，所以要加static，或者没用
        if (ticket > 0) {
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":票号为：" + ticket);
            ticket--;
        }
    }
}


public class WindowTest06 {
    public static void main(String[] args) {
        Window06 test1=new Window06();
        Window06 test2=new Window06();
        Window06 test3=new Window06();
        test1.setName("窗口1");
        test2.setName("窗口2");
        test3.setName("窗口3");
        test1.start();
        test2.start();
        test3.start();
    }
}


