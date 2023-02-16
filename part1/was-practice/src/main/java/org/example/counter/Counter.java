package org.example.counter;

public class Counter implements Runnable{

    private int count = 0;

    public void increment() {
        count++;
    }

    public void decrement() {
        count--;
    }

    public int getValue() {
        return count;
    }

    @Override
    public void run() {
        increment();
        System.out.println("Value for Thread After Increment " + Thread.currentThread().getName() + " " + getValue());
        decrement();
        System.out.println("Value for Thread at last " + Thread.currentThread().getName() + " " + getValue());
    }
}
