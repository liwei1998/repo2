package com.obtk.test;

/**
 * 创建多线程的方式二：实现Runnable接口
 * 1.创建Runnable的实现类
 * 2.实现类去实现Runnable中的抽象方法:run()
 * 3.创建实现线程的一个对象 p
 * 4.将此对象传入到Thread的构造器中，创建Thread的对象
 * 5.通过Thread调用Start()的方法
 */

class  MyThread02 implements Runnable{
    private  int i;
    @Override
    public void run() {
        for ( i = 1; i <=10 ; i++) {
            System.out.println(Thread.currentThread().getName()+"  "+i);
        }
    }
}

public class RunnableTest01 {
    public static void main(String[] args) {
        MyThread02 myThread02 = new MyThread02();
        Thread thread = new Thread(myThread02);
        //为什么可以调用到重写后的run()方法呢，在源码里面对Thread的构造器做了赋值，在run()方法中做了判断
        //调用run方法
        thread.start(); //调用了当前线程的run()--->调用了Runnable类型的target的run()
        Thread thread2 = new Thread(myThread02);
        thread2.start();
        Thread thread3 = new Thread(myThread02);
        thread3.start();
    }

}
