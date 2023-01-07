package com.company;

//public class Waiter implements Runnable {
//
//        String lock="Lock";
//        Waiter(String name){
//            Thread.currentThread().setName(name);
//        }
//        public static synchronized void prepareFood(){
//        System.out.println("Food Preparing "+Thread.currentThread().getName());
//        try {
//            Thread.sleep(1000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("Food Prepared "+Thread.currentThread().getName());
//    }
//
//        @Override
//        public void run () {
//
//                System.out.println("Order taken "+Thread.currentThread().getName());
//                 prepareFood();
//
//        }
//
//}
