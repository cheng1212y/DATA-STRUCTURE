/**
 * @Description:   手动实现无头双向链表
 * @Author: Cheng
 * @Create: 2020-04-26 22:32
 **/

class Node {
    public int data; //数据
    public Node prev;//前驱信息
    public Node next;//后继信息

    public Node(int data) {
        this.data = data;
        this.prev = null; //不初始化 也可以 默认值是null
        this.next = null;
    }
}

public class MyDoubleLinkedList {

    public Node head; // head类型也是一个Node类型 ， head也是一个引用 ，用来保存头结点的地址
    //代表整个单链表一长串的头 不是某个结点的头，保存单链表头结点的引用，head只是表示当前暂时头在那 有可能删掉

    public Node tail; //用来标志当前双向链表的尾巴 方便采用尾插法

    /*** -------------------1头插法---------------------- */
    public void addFirst(int data) {
        Node node = new Node(data);
        if ( this.head == null  )  {  //第一次插入的情况
            this.head = node;
            this.tail = node;
            return;
        }// 不是第一次插入
        node.next = this.head;   //先后继
        this.head.prev = node;  //前驱
        this.head =node;        //头
    }
    /*** -------------------2打印---------------------- */
    public void display() {
        Node cur = this.head;
        while (cur != null)  {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }

    /*** -------------------3尾插法---------------------- */
    public void addLast(int data) {
        Node node = new Node(data);
        if ( this.head == null  )  {  //第一次插入的情况
            this.head = node;
            this.tail = node;
            return;
        }// 不是第一次插入
        this.tail.next = node;  //先后继
        node.prev = this.tail;   //前驱
        this.tail = this.tail.next;  //尾
    }

    /*** --------4查找是否包含关键字key是否在单链表当中---------- */
    public boolean contains(int key) {
        Node cur  =  this.head;
        while ( cur != null ) {
            if ( cur.data == key ) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /*** --------5查得到单链表的长---------- */
    public int size() {
        Node cur = this.head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }


    /*** -------------------找下标index位置的地址------------------ */
    private  Node searchIndex ( int index) {  //---------找到插入的位置的地址
        if (index < 0 || index > size()) {  // 6个元素 0--5下标 可以插6
            throw new RuntimeException(" index 位置不合法");
        }
        Node cur = this.head;
        while ( index != 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }
    /*** -------------------6 中间插入------------------ */
    public void addIndex(int index, int data) { //开始插入
        if (index == 0 ) { //1头插法
            addFirst(data);
            return;
        }
        if (index == size()) {      // 2尾插法
            addLast(data);
            return;
        }
        //3中间插
        Node cur  = searchIndex(index); // ------接收期望插入下标的地址
        Node node = new Node(data);  //生成新的node
        node.next = cur;      //外层后
        node.prev = cur.prev;//外前
        cur.prev.next = node;//内前
        cur.prev = node;//内后
    }

    /**------------------------7删除第一次出现的key------------------*/
    public int remove(int key){
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == key) { //找元素
                int oldData = cur.data;// 如果cur.data=key 记录一下最后要返回 找到了就标记一下
                //1要删除的元素正好是头结点
                if( cur == this.head ) {
                    this.head = this.head.next; //要删除的元素正好是头结点
                    this.head.prev = null;      //头结点的prev要置为空

                    //2不是头结点(内包含普通与尾结点)
                }else {
                    cur.prev.next = cur.next;//前绑后
                    if(cur.next != null) {//不是最后一个元素 那么del前后都绑  若del的next都为空了 说明它是最后一个元素 只用绑前面
                        cur.next.prev = cur.prev; //后绑前
                    }
                    else {
                        this.tail = cur.prev;    /**删除尾巴结点  tail位置往前挪一个*/
                    }
                }
                //找到data了开始 删除结点完毕
                return oldData;
            }
            cur = cur.next; //不相等 cur就往后走
        }
        return -1;
    }




    /**------------------------8删除所有值为key的节点------------------*/

    public void removeAllKey(int key) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == key) { //找元素
                //1要删除的元素正好是头结点
                if( cur == this.head ) {
                    this.head = this.head.next; //要删除的元素正好是头结点
                    if (this.head != null) { /** 排除结点 222 这种情况空指针异常 因为走到最后一个结点 head已经为空*/
                        this.head.prev = null;      //头结点的prev要置为空
                    }

                    //2不是头结点(内包含普通与尾结点)
                }
                else {
                    cur.prev.next = cur.next;//前绑后
                    if(cur.next != null) {//不是最后一个元素 那么del前后都绑  若del的next都为空了 说明它是最后一个元素 只用绑前面
                        cur.next.prev = cur.prev; //后绑前
                    }
                    else {
                        this.tail = cur.prev;    /**删除尾巴结点  tail位置往前挪一个*/
                    }
                }
            }
            cur = cur.next; //不相等 cur就往后走
        }
    }

    /**------------------------清空链表------------------*/
    public void clear() {

        while ( head != null ) {
            Node cur = this.head.next;
            head.next = null;
            head.prev = null;
            head =cur;
        }
        this.tail = null;
    }


}


