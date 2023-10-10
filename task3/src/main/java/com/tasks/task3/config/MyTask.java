package com.tasks.task3.config;

public class MyTask implements Runnable{

    private String message;

    MyTask(String message){
        this.message = message;
    }

    public void run() {
        System.out.println(message);
    }
}
