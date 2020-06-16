package com.obtk.exer;

/**
 *  使用俩个线程打印1-100  线程1 线程2 交替打印
 *  涉及到的三个方法：
 *  wait():调用wait后，该线程会阻塞，并释放当前同步锁
 *  notify():一旦执行此方法，就会唤醒wait的一个线程，如果有多个线程被wait，就唤醒优先级高的
 *  notifyAll():一旦执行此方法，会唤醒所有被wait的线程
 *
 *  说明：
 *  1.wait(),notify(),notifyAll()三个方法必须使用在同步代码块同步方法中
 *  2.wait(),notify(),notifyAll()三个方法的调用者必须是同步代码块或同步方法中的同一个同步监视器
 *  3.wait(),notify(),notifyAll()三个方法是定义在java.lang.Object类中
 */

class Number implements Runnable{

    private  int  number=1;
    @Override
    public void run() {
        while(true){
            synchronized (this){
                //如果线程1先进入，调用wait后，会阻塞，并且线程1会释放锁，让线程2进入，当线程2进入的时候，会调用notify，线程1会释放资源
                this.notifyAll();
            if (number<=100){
                System.out.println(Thread.currentThread().getName()+":  "+number);
                number++;
            }else {
                break;
            }
                try {
                    //使得调用如下的wait线程进入阻塞状态
                    //调用wait会释放锁
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class WaitTest {
    public static void main(String[] args) {
        Number number=new Number();
        Thread thread1 = new Thread(number);
        Thread thread2= new Thread(number);
        Thread thread3= new Thread(number);
        thread1.start();
        thread2.start();
        thread3.start();


    }
}
