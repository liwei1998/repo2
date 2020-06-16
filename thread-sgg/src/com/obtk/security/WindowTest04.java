package com.obtk.security;

/**
 * 使用同步代码块解决继承Thread类方式的安全问题
 */
class Window04 extends Thread{
    private  static  int ticket=100;  //如果不要static 相当于每个窗口都有一百张票，声明static后，
                                     // 相当于三个线程共享这一个静态变量，三个窗口一共就只有100张票

    static Object object=new Object();//继承Thread 实现共享100张票创建的是三个对象，每声明一个对象，obj都不同
                                      //所以在同步监视锁的时候，必须要声明static的静态变量
    @Override
    public    void run() {
        while (true){

            synchronized(Window04.class) { //Window04.class只会加载一次
            //正确的
           // synchronized(object) {
                //错误的方式 this代表的是三个对象， 此操作只在Runnable中可用
               // synchronized(this) {
                if (ticket > 0) {
                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + ":票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}


public class WindowTest04 {
    public static void main(String[] args) {
        Window04 test1=new Window04();
        Window04 test2=new Window04();
        Window04 test3=new Window04();
        test1.setName("窗口1");
        test2.setName("窗口2");
        test3.setName("窗口3");
        test1.start();
        test2.start();
        test3.start();
    }
}
