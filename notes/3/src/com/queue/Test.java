package com.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:   库中的队列
 * @Author: Cheng
 * @Create: 2020-05-14 16:24
 **/
public class Test {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(99);
        queue.offer(7);
        queue.offer(2);
        queue.offer(16);
        System.out.println(queue);
        System.out.println("===================");
        System.out.println(queue.peek());  // 只拿到对头 但是不删除
        System.out.println(queue.poll());  // 出队 会删除队头元素
        System.out.println(queue.peek());
        System.out.println(queue.element());


    }
}
