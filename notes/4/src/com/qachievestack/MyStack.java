package com.qachievestack;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description:   使用两个队列 实现一个栈   哪个不为空 就先操作哪个
 *
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 *
 * @Author: Cheng
 * @Create: 2020-05-15 12:34
 **/
public class MyStack {

    public Queue<Integer> queue1; // 得到两个队列
    public Queue<Integer> queue2;

    public MyStack() {                  //通过构造方法得到两个队列
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** 1、入栈 */
    public void push(int x) {
        //1、哪个队列不为空就放到哪个中
        if ( !queue1.isEmpty()) {
            queue1.offer(x);
        }
        else if (!queue2.isEmpty()){
            queue2.offer(x);
        }
        //2、都为空 规定放到queue1中
        else {
            queue1.offer(x);
        }
    }

    /** 2、弹出栈删除 */
    public int pop() {
        //1、栈为空的情况
        if (empty()) {
            return -1;
        }
        int qSize1 = queue1.size();  //保存住队列的长度
        int qSiez2 = queue2.size();
        int data = 0;
        //2、出不为空的那个队列 n个元素的话 将n-1个倒进另一个队列
        if (!queue1.isEmpty()) {
            for (int i = 0; i <qSize1-1 ; i++) {    /** 长度减去1 是为了弹出前n-1个元素*/
                int val = queue1.poll();           //弹出队列中除最后一个的所有元素
                queue2.offer(val);                 // 另一个队列接受弹出的元素
            }
             data = queue1.poll();                 //最后一个元素就是需要出栈的 栈顶元素
        }

         else {
            for (int i = 0; i <qSiez2-1 ; i++) {
                int val = queue2.poll();
                queue1.offer(val);
            }
                data = queue2.poll();
        }
                return data;
    }

    /** 3、得到栈顶元素 */
    public int top() {
        //1、栈为空的情况
        if (empty()) {
            return -1;
        }
        int qSize1 = queue1.size();  //保存住队列的长度
        int qSiez2 = queue2.size();
        int data = 0;
        //2、出不为空的那个队列  n个元素倒入另一个队列
        if (!queue1.isEmpty()) {
            for (int i = 0; i <qSize1 ; i++) {
                 data = queue1.poll();
                queue2.offer(data);               //最后一个val就是栈顶元素
            }
        }

        else {
            for (int i = 0; i <qSiez2 ; i++) {
                 data = queue2.poll();
                queue1.offer(data);
            }
        }
        return data;
    }
    /** 4、判空 */
    public boolean empty() {
        if(queue1.isEmpty() && queue2.isEmpty()) {
            return true;
        }
            return false;
    }
}
