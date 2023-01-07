package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

//        Runnable runnable=new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Order taken "+Thread.currentThread().getName());
//                prepareFood();
//
//            }
//            public static synchronized void prepareFood(){
//                System.out.println("Food Preparing "+Thread.currentThread().getName());
//                try {
//                    Thread.sleep(3000);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//                System.out.println("Food Prepared "+Thread.currentThread().getName());
//            }
//        };
//        Thread thread1=new Thread(runnable);
//        thread1.start();
//        Thread thread2=new Thread(runnable);
//        thread2.start();

//        Waiter one=new Waiter("onehhh");
//        Thread thread1=new Thread(one);
//        thread1.start();
//        Waiter two =new Waiter("two");
//        Thread thread2=new Thread(two);
//        thread2.start();
//        Waiter three =new Waiter("third");
//        Thread thread3=new Thread(three);
//        thread3.start();


        Object key=new Object();
        Queue<Integer> queue=new LinkedList<Integer>();
        int size=10;

        Thread producer=new Thread(new Runnable() {
            @Override
            public void run() {
                int count=0;
                while (true) {
                    synchronized (key) {
                        try {
                            while (queue.size()==size)
                                key.wait();

                            queue.offer(count++);
                            key.notifyAll();

                            Thread.sleep(1000);
                            System.out.println("MOMO producer,plate size="+queue.size());

                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        Thread consumer=new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (key) {

                        try {
                            while (queue.size()==0)
                                key.wait();

                            queue.poll();
                            key.notifyAll();

                            Thread.sleep(3000);
                            System.out.println("Momo Consumed,Plate size="+queue.size());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        });
        producer.start();
        consumer.start();

    }
}
