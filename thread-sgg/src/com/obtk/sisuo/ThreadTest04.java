package com.obtk.sisuo;

class  A{
    public synchronized void foo(B b){
        System.out.println(Thread.currentThread().getName()+"开始执行,进入了foo");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        b.last();
    }
    public synchronized void last(){
        System.out.println("A线程执行完成了");
    }

}

class B{
    public synchronized void bar(A a){
        System.out.println(Thread.currentThread().getName()+"开始执行");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a.last();
    }
    public synchronized void last(){
        System.out.println("B线程执行完成了");
    }
}

public class ThreadTest04 implements Runnable{
    A a = new A();
    B b =new B();


    public  void init(){
        Thread.currentThread().setName("主线程");
        a.foo(b);
    }

    @Override
    public void run() {
        Thread.currentThread().setName("副线程");
        b.bar(a);
    }

    public static void main(String[] args) {

        ThreadTest04 test=new ThreadTest04();

        new Thread(test).start();
        test.init();

    }
}
