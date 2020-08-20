package com.minstack;

import java.util.Stack;

/**
 * @Description:       实现一个最小栈
 * @Author: Cheng
 * @Create: 2020-05-15 14:46
 **/
public class MinStack {

    public Stack<Integer> stack;  //两个栈
    public Stack<Integer> minStack;

        public MinStack() {             //构造方法得到普通栈 和最小栈
            stack = new Stack<>();
            minStack = new Stack<>();
        }
        /** 1、压栈 */
        //栈1是一直要放元素的
        //最小栈放不放元素 取决于 元素和最小栈栈顶的关系
        //小于 等于就放进去  大于不放进最小栈
        public void push(int x) {
            //1、栈1肯定要放元素
                stack.push(x);
            //栈2 为空的就放元素
            if ( minStack.isEmpty()) {
                minStack.push(x);
            }
            //栈2 不为空
            else {
                //判断元素与栈2 的栈顶的关系、如果小于就放进去栈2 否则不放进栈2
                int top = minStack.peek();
                if ( x <= top ) {
                    minStack.push(x);
                }
            }
        }
    /** 2、弹出栈删除 */
        public void pop() {
            //栈1是一直弹出元素的
            //最小栈弹不弹出元素 取决于 元素在不在最小栈栈顶的
            //在的话就弹出
            if ( !stack.isEmpty()) {
                int data = stack.pop();

                if (data == minStack.peek()) {
                    minStack.pop();
                }
            }
        }
    /** 3、得到栈顶元素-----------操作的是普通栈 */
        public int top() {
            if (stack.empty()) {
                return -1;
            }
            return stack.peek();
        }

    /** 4、得到最小元素 */
        public int getMin() {
            if (minStack.empty()) {
                return -1;
            }
            return minStack.peek();
        }
    }
