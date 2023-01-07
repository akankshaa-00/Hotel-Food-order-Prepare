package com.company;

public class Main {

    public static void main(String[] args) {

        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                System.out.println("Order taken "+Thread.currentThread().getName());
                prepareFood();

            }
            public static synchronized void prepareFood(){
                System.out.println("Food Preparing "+Thread.currentThread().getName());
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.println("Food Prepared "+Thread.currentThread().getName());
            }
        };
        Thread thread1=new Thread(runnable);
        thread1.start();
        Thread thread2=new Thread(runnable);
        thread2.start();

//        Waiter one=new Waiter("onehhh");
//        Thread thread1=new Thread(one);
//        thread1.start();
//        Waiter two =new Waiter("two");
//        Thread thread2=new Thread(two);
//        thread2.start();
//        Waiter three =new Waiter("third");
//        Thread thread3=new Thread(three);
//        thread3.start();

    }
}
