package com.circularqueue;

/**
 * @Description:
 * @Author: Cheng
 * @Create: 2020-05-15 10:45
 **/
public class TestMain {
    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(10 ) ;
        myCircularQueue.enQueue(111);
        myCircularQueue.enQueue(4);
        myCircularQueue.enQueue(3);
        myCircularQueue.enQueue(2);
        System.out.println(myCircularQueue.isEmpty());


    }
}
