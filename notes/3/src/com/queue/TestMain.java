package com.queue;

/**
 * @Description:
 * @Author: Cheng
 * @Create: 2020-05-14 16:11
 **/
public class TestMain {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.offer(11);
        myQueue.offer(8);
        myQueue.offer(6);
        myQueue.offer(22);
        System.out.println(myQueue.usedSize);
        System.out.println(myQueue.empty());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.peek());
    }
}
