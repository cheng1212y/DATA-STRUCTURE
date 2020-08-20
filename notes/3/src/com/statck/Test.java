package com.statck;

import java.util.Stack;

/**
 * @Description:  栈的 操作 pop push peek search empty
 * 注意： search 是从栈顶开始计数  栈顶是1 位置
 * @Author: Cheng
 * @Create: 2020-05-14 14:06
 **/
public class Test {
    public static void main(String[] args) {
        Stack< Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(22);
        stack.push(33);
        stack.push(66);
        System.out.println(stack);
        System.out.println("==================");
        System.out.println(stack.peek());
        System.out.println(stack.search(66));
        System.out.println(stack.search(33));
        System.out.println(stack.search(22));
        System.out.println(stack.search(1));
        System.out.println(stack.pop());
        System.out.println(stack.empty());
        System.out.println(stack.size()); //继承了vector 就有了size方法


    }
}
