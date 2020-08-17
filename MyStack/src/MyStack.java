import java.util.Arrays;

/**
 * @Description:   顺序表尾插 手动实现栈  push、pop、peek、empth、size  注意： search 是从栈顶开始计数  栈顶是1 位置
 * @Author: Cheng
 * @Create: 2020-08-17 14:39
 **/

public class MyStack <T> {

    public T [] elem ;       // 数组
    public int top ;        //表示当前可以存放数据元素的下标

    public MyStack() {
        this.elem = (T [])new Object [ 10 ];
        this.top = 0;
    }
    /** -----------------1、push入栈-----------*/
    private  boolean isFull () {       //判断栈是否已满了
        return this.top == this.elem.length ;
    }
    public T push (T data) {
        if ( isFull()) {
            this.elem = Arrays.copyOf(this.elem,this.elem.length*2);//栈满的话就2倍扩容
        }

        this.elem[top] = data; //添加元素
        top++;                  //top++
        return data;
    }
    /** -----------------2、pop弹出栈及删除-----------*/
    public T pop ( ) {
        if (empty()) {                          //栈可能 为空的情况
            throw new RuntimeException("栈空");
        }
        T data = this.elem[ this.top -1 ];
        this.top--;     //删除的时候 top减去1 ，下次再添加元素就会覆盖原来的 相当于删除
        return data;
    }
    /** -----------------3、peek得到栈顶元素-----------*/

    public T peek () {
        if (empty()) {
            throw new RuntimeException("栈空");
        }
        return this.elem[this.top -1];
    }
    /** -----------------4、得到栈的长度-----------*/

    public int siez () {
        return this.top;
    }
    /** -----------------5、判断栈是否为空-----------*/
    public boolean empty () {
        return this.top == 0 ;
    }
}
