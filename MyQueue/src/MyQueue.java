/**
 * @Description:    链表手动实现队列   offer、poll、peek、empty、size
 *
 *                  尾插法+tail标记     新增：O(1)  删除O(1)
 * @Author: Cheng
 * @Create: 2020-08-17 14:51
 **/
class Node {
    public int data ;  //数据
    public Node next ; //下一个结点的引用

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class MyQueue {
    public Node head ;
    public Node tail ; //添加尾巴引用 是为了使得尾插时候 入队的时间复杂度是 O(1)
    public  int usedSize;  // 队列的长度

    /** -------------1、offer入队------------*/
    public  boolean offer(int data) {
        Node node = new Node(data);

        if ( head == null ) {    //第一次插入的时候
            this.head = node;
            this.tail = node;
        }
        else {         //不是第一次插入 尾插法
            this.tail.next = node; //尾巴引用
            this.tail = node;
        }
        this.usedSize++;
        return true;
    }

    /** -------------2、poll弹出删除队头------------*/
    public int poll () {

        if ( empty()) {
            throw new RuntimeException("队列为空");
        }
        int data = this.head.data;  //删除之前先记录值
        this.head = this.head.next; //队列是先删头
        return data;
    }
    /** -------------3、peek得到队头------------*/
    public int peek ( ) {
        if ( empty()) {
            throw new RuntimeException("队列为空");
        }
        return this.head.data; //直接得到队头值
    }
    /** -------------4、empty队列是否为空------------*/
    public boolean empty ( ) {
        return this.usedSize == 0;
    }
    /** -------------5、size得到长度------------*/
    public int size ( ) {
        return this.usedSize;
    }





}

