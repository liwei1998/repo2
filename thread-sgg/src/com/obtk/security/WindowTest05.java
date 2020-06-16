package com.obtk.security;

/**
 * 使用同步方法解决实现Runnable接口的线程安全问题
 */

class  Window05 implements Runnable{

    private  int   ticket=100;
    Object object=new Object();
    Dog dog=new Dog();


    @Override
    public  void run() {
        while (true){
            show();
        }
    }
    public  synchronized    void  show(){//同步监视器：在这个方法声明中 表示为this
        //synchronized(this){
        if (ticket>0){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"  "+ticket);
            ticket--;
        }
      //  }
    }
}


public class WindowTest05 {
    public static void main(String[] args) {
        //为什么不用加static也只有一百张票，是因为我们只创建了一个对象，只是多开了几个线程
        //相当于几个线程共享了一个对象
            Window05 test=new Window05();
            new Thread(test).start();
            new Thread(test).start();
            new Thread(test).start();
    }
}



