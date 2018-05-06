package com.lamdaespression;

public class ThreadWithLambda {

    public static void main(String[] args) {
        Thread thread = new Thread( new Runnable(){

            public  void run(){
                System.out.println("Traditional thread run call");
            }
        });

        Thread thread1 = new Thread( ()-> System.out.println("Lambda runnable call") );

        thread.run();
        thread1.run();
    }

}
