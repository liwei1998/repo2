package com.obtk.lanhan;

public class BankTest {
}

class Bank{
    private static Bank bank=null;

    public Bank() {
    }

    private static  Bank getInstance(){
        //方式一 效率差
//        synchronized (Bank.class) {
//            if (bank==null){
//                bank=new Bank();
//            }
//            return bank;
//        }
        //方式二：效率高
        if (bank==null){
            synchronized (Bank.class) {
                if (bank==null){
                    bank=new Bank();
                }

            }
        }
        return bank;
    }

}
