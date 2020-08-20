package genericity;

import java.util.Objects;
/**
 * @Description:      普通的类 改为 泛型类
 * @Author: Cheng
 * @Create: 2020-05-28 13:40
 **/

/**
 *  * <T> : 只是一个占位符，表示当前类是一个泛型类
 *  * 泛型的意义：
 *  * 1、可以自动进行类型的检查
 *  * 2、可以自动进行类型的转换
 *
 *  * 泛型的坑：
 *  * 1、不能new泛型类型的数组。T a =  new T[10];
 *  * 2、简单类型不能作为泛型类型的参数，MyArrayList<float> myArrayList3 = new MyArrayList<>();
 *  *3、 泛型类型参数，不参与类型的组成。
 *  *      MyArrayList<Integer> myArrayList = new MyArrayList<>();
 *  *      MyArrayList@154617c  中间并没有尖括号 说明运行时候被擦除了
 *
 *  4、泛型只是编译时期的一种机制，就叫擦除机制。在运行的时候，不存在泛型这种说法。所有的处理均在编译阶段已经处理。
 * 编译的时候把T擦除成了Object 这样一来，各种类型都可以放
 *
 * */

class MyStack <T>{
    public  T [] elem ;
    public  int top;
    public MyStack( ) {
        this.elem = (T []) new Objects[10];
        this.top = 0;
    }
    public void push(T val) {
        this.elem[this.top] = val;
        this.top++;
    }
    public T peek() {
        return this.elem[this.top-1];
    }
 }
public class Test {
    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(12 );
        int a = myStack.peek();
        System.out.println(a);
    }







}
