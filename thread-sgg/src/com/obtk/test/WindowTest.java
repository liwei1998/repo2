package com.obtk.test;

/**
 * 例子：创建三个窗口去卖票，总数为100张
 *
 * 存在线程的安全问题
 */

class Window extends Thread{
    private  static  int ticket=5;  //如果不要static 相当于每个窗口都有一百张票，声明static后，
                                    // 相当于三个线程共享这一个静态变量，三个窗口一共就只有100张票
    @Override
    public  void run() {
      while (true){
          if (ticket>0){
              System.out.println(getName()+":票号为："+ticket);
              ticket--;
          }else {
              break;
          }
      }
    }
}


public class WindowTest {
    public static void main(String[] args) {
        Window test1=new Window();
        Window test2=new Window();
        Window test3=new Window();
        test1.setName("窗口1");
        test2.setName("窗口2");
        test3.setName("窗口3");
        test1.start();
        test2.start();
        test3.start();
    }
}

