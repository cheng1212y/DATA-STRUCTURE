/**
 * @Description:  循环队列手动实现----通过顺序表
 *                  通过rear的下一个是front 判断队列为满，rear == front 是空
 *                  顺着开：下标最后再往后(offset 小于 array.length): index = (index + offset) % array.length
 *                  倒着开：下标最前再往前(offset 小于 array.length): index = (index + array.length - offset) % array.length
 *
 * @Author: Cheng
 * @Create: 2020-08-17 15:20
 **/

public class MyCircularQueue {
    public int [] elem ;
    public int front; //头
    public int rear;  //用来标识可以存放元素的下标
    public MyCircularQueue(int k) {
        this.elem = new int[k];
    }
    /** 1、入队*/

    public boolean enQueue(int value) {
        if (isFull()) {
            return false; //1队列为满的
        }
        //2有空位的情况
        this.elem[this.rear] = value;
        this.rear = ( rear + 1 ) % this.elem.length; //防止数组越界，0-7下标，rear需要从7下标到0的尴尬
        return true;

    }
    /**2、出队*/
    public boolean deQueue() {
        if (isEmpty()) {        //队列为空 不需要出队
            return false;
        }
        //队列不为空
        this.front = (this.front + 1 ) % this.elem.length; //排除 7 -0的情况
        return true;

    }
    /** 3、返回队头元素. */
    public int Front() {
        if (isEmpty()) {   //队列为空的情况
            return -1;
        }
        //不为空
        return this.elem[this.front];
    }
    /**------4、返回队尾元素------------- */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        //通过 判断普通位置是rear-1  特殊位置0 数组的长度-1
        int index = this.rear == 0 ? this.elem.length-1 : this.rear-1;
        return this.elem[index];
    }
    /** 5、判断队列是否为空 */
    public boolean isEmpty() {
        return this.front == this.rear;   //两个相遇的时候为空队列
    }
    /** 6、判断队列是否为满 */
    public boolean isFull() {
        if (( this.rear +1) % this.elem.length == this.front ) {  //规避了极端情况 7-0
            return  true;
        }
        return false;
    }
}



