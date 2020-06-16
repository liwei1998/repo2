package com.obtk.test;

import static java.lang.Thread.sleep;

/**
 * 1.start() 执行该线程
 * 2.run()   重写run（）方法，将创建的线程需要执行的操作写入到此方法中
 * 3.currentThread():静态方法，返回当前执行代码的线程
 * 4.getName 返回当前线程的名字
 * 5.setName 设置当前线程的名字
 * 6.yield():释放当前cpu的执行权
 * 7.join(): 在线程a中调用线程b的join(),此时线程a进入阻塞状态，直到线程b执行完之后，线程a结束阻塞状态，再去执行
 * 8.stop(): 已过时。当执行方法的时候，强制结束当前进程
 * 9.sleep(long millis): 睡眠，休眠指定的时间，当前是阻塞的状态
 *10.isAlive():判断当前线程是否存活
 *
 * 线程的优先级
 *  MIN_PRIORITY = 1;
 *  NORM_PRIORITY = 5;
 *  MAX_PRIORITY = 10;
 *
 * 2.如何获取和设置当前线程的优先级
 *      getPriority();
 *      setPriority(int P);
 *      setPriority可以设置线程的优先级，高优先级的会抢占低优先级cpu的执行权，
 *      设置的值比较高的，从概率上来讲会优先执行，实际上也不一定
 * */
class  HelloThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2==0){
//                try {
//                    sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName()+"   "+i);
            }
//            if (i%20==0){
//                yield();
//            }
        }
    }

    public HelloThread(String name) {
        super(name);
    }
}

public class ThreadMethodTest {
    public static void main(String[] args) throws InterruptedException {
        //给主线程命名
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(1);
        HelloThread a=new HelloThread("线程1");
//        a.setName("线程1");
        a.setPriority(Thread.MAX_PRIORITY);
        a.start();

        for (int i = 0; i < 100; i++) {
            if (i%2!=0){
                System.out.println(Thread.currentThread().getName()+"   "+i);
            }
         /*   if (i==59){
                a.join();
//                a.stop();
            }*/
        }
        System.out.println(Thread.currentThread().isAlive());

    }
}
