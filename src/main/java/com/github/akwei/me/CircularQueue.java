package com.github.akwei.me;

import java.util.concurrent.ConcurrentLinkedQueue;

public class CircularQueue {
    private final String[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public CircularQueue(int capacity) {
        this.items = new String[capacity];
        n = capacity;
    }

    public boolean enqueue(String item) {
        if ((tail + 1) % n == head) {
            return false;
        }
        items[tail] = item;
        return true;
    }

    public String dequeue() {
        if (head == tail) {
            return null;
        }
        String result = items[head];
        head = (head + 1) % n;
        return result;
    }

    public static void main(String[] args) {
//        CircularQueue obj1 = new CircularQueue(2);
//        CircularQueue obj2 = obj1;
//        CircularQueue obj3 = obj1;
        ConcurrentLinkedQueue<Integer> queue=new ConcurrentLinkedQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println("end");
    }
}
