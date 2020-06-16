package com.obtk.test;

/**
 *   创建多线程的方式一：及成果Thread类
 *   1.创建一个继承于thread的子类
 *   2.重写thread类的run（）
 *   3.创建Thread的子类对象
 *   4.通过此对象调用start（）
 *
 */
class MyThread extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+"   "+i);
            }
        }

    }
}

public class TestThread01 extends Thread {
    public static void main(String[] args) {

        MyThread te=new MyThread();

        te.start();

        MyThread te2=new MyThread();
        te2.start();
        for (int i = 0; i < 100; i++) {
            if (i%2==1){
                System.out.println(i+"***************main()*******************"+Thread.currentThread().getName());
            }
        }
    }


}
