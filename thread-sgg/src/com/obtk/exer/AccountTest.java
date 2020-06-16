package com.obtk.exer;

import jdk.management.resource.internal.inst.ThreadRMHooks;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 银行1有一个账户。
 * 有两个储户分别向同同一个账户存3000元，每次存1000，存3次，每次存完打印金额
 * 分析：
 * 1.是否是多线程的问题？是 ，俩个储户线程
 * 2.是否有共享数据
 * 3.是否有线程安全问题
 * 4.如何解决线程安全问题
 */
/*
class Account{
    private double balance;
    private static ReentrantLock lock=new ReentrantLock();


    public Account() {

    }

    //存钱
    public  void    deposit(double amt){
        try {
            lock.lock();
        if (amt>0){
            balance+=amt;

                Thread.sleep(500);

            System.out.println(Thread.currentThread().getName()+"存钱成功，余额为："+balance);
        }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

class  Customer extends Thread{

    private Account acct;

    public Customer(Account acct) {
        this.acct = acct;
    }

    @Override
    public void run() {
        for (int i = 0; i <3 ; i++) {
            acct.deposit(1000);
        }

    }
}



public class AccountTest {
    public static void main(String[] args) {
        Account acct=new Account();
        Customer customer1=new Customer(acct);
        Customer customer2=new Customer(acct);
        customer1.setName("甲");
        customer2.setName("乙");
        customer1.start();
        customer2.start();



    }
}*/

class Account{
    private  double balance;

    public synchronized void  cunqian(int num){
        balance+=num;
        System.out.println(Thread.currentThread().getName()+"存了"+balance);
    }

}

class Custome extends Thread{
    private  Account account;

    public Custome(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.cunqian(100);
        }
    }
}

public class AccountTest{
    public static void main(String[] args) {
        Account account=new Account();
        Custome custome1 = new Custome(account);
        Custome custome2 = new Custome(account);
        custome1.setName("甲3");
        custome2.setName("乙3");
        custome1.start();
        custome2.start();

    }


}
