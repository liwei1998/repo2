package com.obtk.security;

/**
 * 例子：创建三个窗口去卖票，总数为100张,使用Runnable的方式实现
 *
 * 解决线程的安全问题
 * 1.问题：卖票过程中，出现了重票，错票 --->出现了线程安全问题
 * 2.问题出现的原因：当一个线程在操作的时候，还没有完成，另一个线程也进来操作，导致数据重复或错误
 * 3.解决问题：加一把锁，当A线程的事情没有做完的时候，让另一个线程先等着，直到A线程完成，B线程再进入
 * 4.在Java中，我们通过同步机制，来解决线程的安全问题
 *  方式一：同步代码块
 *  synchronized (同步监视器){
 *
 *      //需要被同步的代码：操作共享数据的代码
 *
 *  }
 *  1.操作共享数据的代码，即为需要被同步的代码：
 *  2.共享数据：多个线程共同操作的变量
 *  3.同步监视器，俗称：锁. 任何一个类的对象，都可以充当锁
 *      要求：多个线程必须共用一把锁！！！！(很重要)
 *  方式二：同步方法
 *
 *
 * 同步的方式，解决了线程的安全问题  --好处
 * 操作同步代码时，只能有一个线程参与，其他线程等待，相当于一个单线程的过程，效率低
 *
 * */

class  Window03 implements Runnable{

    private  int   ticket=100;
    Object object=new Object();
    Dog dog=new Dog();


    @Override
    public  void run() {
//        Object object=new Object(); 可以是任何一个对象，但是放在这里声明，就不是共享一把锁，所以会无效
        while (true){ //这段代码不能放在synchronized里面，不然相当于一个窗口把票卖完了，剩余的俩个线程还在等着
            synchronized (Window03.class){
            //synchronized (this){ //此时的this：唯一的Window1的对象  //(dog) （obj）都行
            if (ticket>0){

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"  "+ticket);
                ticket--;
            }else{
                break;

            }
            }
        }
    }
}


public class WindowTest03 {
    public static void main(String[] args) {
        //为什么不用加static也只有一百张票，是因为我们只创建了一个对象，只是多开了几个线程
        //相当于几个线程共享了一个对象
            Window03 test=new Window03();
            new Thread(test).start();
            new Thread(test).start();
            new Thread(test).start();
    }
}

class  Dog{

}

