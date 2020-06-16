package com.obtk.test;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
//        Integer i = new Integer(100);
////        Integer j = new Integer(100);
////
////        System.out.print(i == j); //false

/*        int [] a={89,1,3,7,8};
        int [] b=new int[2];
        System.out.println(a);
        int temp=0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length-1-i; j++) {
                if (a[j]<a[j+1]){
                   temp=a[j];
                   a[j]=a[j+1];
                    a[j+1]=temp;

                }

            }
            b=a;
//            System.out.println(a[i]);
        }
        for (int i = 0; i < 2; i++) {
            System.out.println(b[i]);
        }

   */
//    String s="hello";
//    String t = "hello";
//    char c [ ] = {'h','e','l','l','o'};
//
//        System.out.println(s.equals("h"));



 /*       int i=1;
        try {

            i+=1;
            System.out.println(i);
        } finally {
            i+=1;
        }*/
      /*  List a=new ArrayList<>();
        dongwu test=new dog();
        test.chi();*/

        System.out.println(fibonacci(4));

    }
    public static int fibonacci(int n){

        if (n == 1 ) {             //特殊情况，分开讨论
            return 1;
        }
        if (n > 1) {
            return (fibonacci(n - 1) *n);     //递归调用
        }
        return -1;              //如果输入错误的n，一律返回-1
    }

    public static int a(int a){
        if (a==1||a==2){
            return 1;
        }
        return a(a-1)+a(a-2);
    }
}



/*class dongwu{
    public dongwu(){
        System.out.println("父类构造");
    }

    public void chi(){
        System.out.println("父类");
    };
}

class dog extends dongwu{
    public dog(){
        System.out.println("z类构造");
    }

    @Override
    public void chi() {
        System.out.println("吃肉");
    }
}


class cat extends dongwu{
    @Override
    public void chi() {
        System.out.println("吃鱼");
    }
}*/
