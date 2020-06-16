package com.obtk.exer;

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread01 thread01=new MyThread01();
        MyThread02 thread02=new MyThread02();
        thread01.setName("线程1");
        thread01.start();
        thread02.start();
//        new Thread(){
//            @Override
//            public void run() {
//                for (int i = 0; i < 100; i++) {
//                    if (i%2!=0){
//                        System.out.println(Thread.currentThread().getName()+"   "+i);
//                    }
//                }
//            }
//        }.start();
//
//        new Thread(){
//            @Override
//            public void run() {
//                for (int i = 0; i < 100; i++) {
//                    if (i%2==0){
//                        System.out.println(Thread.currentThread().getName()+"   "+i);
//                    }
//                }
//            }
//        }.start();

    }
}

class MyThread01 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2!=0){
                System.out.println(Thread.currentThread().getName()+"   "+i);
            }
        }
    }
}

class MyThread02 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+"   "+i);
            }
        }
    }
}
