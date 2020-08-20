package com.sachievequeue;

import java.util.Stack;

/**
 * @Description:  使用两个栈  实现一个队列          栈1 负责进   栈2 负责出
 *
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 *
 *
 * @Author: Cheng
 * @Create: 2020-05-15 13:38
 **/
public class MyQueue {

    public Stack<Integer> stack1;  //两个栈
    public Stack<Integer> stack2;

    public MyQueue() {      //构造方法得到两个栈
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** 1、入队 */
    public void push(int x) {
        stack1.push(x);   //指定入队到 栈1 当中
    }
    /** 2、弹出队头元素删除. */
    public int pop() {

        if (empty()) {
            return -1;
        }
        if (stack2.isEmpty()) {
            //栈2为空、 将栈1 所以元素倒入栈2
            while (!stack1.isEmpty()) {
                int data = stack1.pop();
                stack2.push(data);
            }
        }
        return stack2.pop(); //栈2不为空 直接出队
    }

    /** 3、得到队头元素. */
    public int peek() {
        if (empty()) {
            return -1;
        }
        if (stack2.isEmpty()) {
            //栈2为空、 将栈1 所以元素倒入栈2
            while (!stack1.isEmpty()) {
                int data = stack1.pop();
                stack2.push(data);
            }
        }
        return stack2.peek(); //栈2不为空 直接拿到队头
    }

    /** 4、队列判空 */
    public boolean empty() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return true;
        }
            return false;
    }


}
