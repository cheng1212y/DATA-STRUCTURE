package com.statck;

/**
 * @Description:
 * @Author: Cheng
 * @Create: 2020-05-14 14:06
 **/
public class TestMain {
    public static void main(String[] args) {
        MyStack <Double>myStack = new MyStack<>();
        myStack.push(1.2);
        myStack.push(2.1);
        myStack.push(3.2);
        myStack.push(4.3);
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
        System.out.println(myStack.siez());
        System.out.println(myStack.empty());
        System.out.println(myStack.push(666.0));
        System.out.println(myStack.peek());
    }
}
