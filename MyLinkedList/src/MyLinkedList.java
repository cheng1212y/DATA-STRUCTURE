/**
 * @Description:  手动实现 无头单向非循环链表
 * @Author: Cheng
 * @Create: 2020-08-10 12:07
 **/

class Node {       // Node是自己定义的一种类型  节点类型

    public int  data ;   //数据
    public Node next;   //next保存的是下一个节点的地址 所以next的类型就应该是Node

    public Node(int data) {    //提供构造方法 可以按照Node类来按模型制造节点
        this.data = data;
        this.next = null;
    }
}


public class MyLinkedList {

    public Node head;               // head类型也是一个Node类型 ， head也是一个引用 ，用来保存头结点的地址
    //代表整个单链表一长串的头 不是某个结点的头，保存单链表头结点的引用，head只是表示当前暂时头在那 有可能删掉
    /**------------------1头插法-----------------------*/
    public void addFirst(int data) {
        Node node = new Node( data); //给构造方法传参数data，按照模板生成一个结点 数据域为data next域为null
        if (this.head == null) {     //首先判断是不是第一次插入 ，第一次插入的时候 head是 null的 因为head是实例成员变量未初始化
            this.head = node;       //直接将node的地址给head   this访问当前对象的属性 成员方法 构造方法，node什么都不算不加
            return;
        }
        node.next = this.head ;   //不是第一次插入   插入的时候首先把绑定后面的结点帮到前面
        this.head = node;         //node绑到head上
    }
    /**--------------2打印链表---------------------------*/
    public void display ( ) {
        Node cur = this.head;                 //创建一个cur指向head结点，直接用head循环结束后 head值会一直往后移，导致头结点改变
        while ( cur != null ) {              //此处判断 cur的值是否为空   cur.next不会遍历到最后一个元素
            System.out.print(cur.data+ " ");
            cur = cur.next;                  // cur是一个对象，要访问它的属性，使用它的引用，自增条件是 cur的值为下一个cur的引用
        }

    }
    /**-------------3尾插法-------------------------*/
    public void addLast ( int data ) {
        Node node = new Node(data);     //给构造方法传参数data，按照模板生成一个结点 数据域为data next域为null
        if(this.head == null) {         //首先判断是不是第一次插入 ，第一次插入的时候 head是 null的 因为head是实例成员变量未初始化
            this.head=node;               //直接将node的地址给head
            return;
        }
        Node cur = this.head;          //创建一个cur指向head结点,直接用head循环结束后 head值会一直往后移，导致头结点改变
        while (cur.next != null) {     /** cur.next！=null 要找到最后一个结点的cur的位置*/
            cur = cur.next;            //每次往后挪一个
        }
        cur.next =node;                 //node绑到最后一个结点上
    }
    /**-----------------4查找是否包含key----------*/

    public boolean contains(int key) {
        Node cur = this.head;        //创建一个cur指向head结点,直接用head循环结束后 head值会一直往后移，导致头结点改变
        while (cur != null) {        // cur ！= null遍历完链表
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;        //每次往后挪一个
        }
        return false;
    }
    /**------------5得到单链表的长度-------------*/
    public int size() {
        int count = 0;
        Node cur = this.head;    //创建一个cur指向head结点,直接用head循环结束后 head值会一直往后移，导致头结点改变
        while (cur != null) {   //  cur ！= null遍历完链表
            count++;
            cur = cur.next;
        }
        return count ;
    }

    /**-----------寻找index位置的前一个地址-------*/
    private Node searchIndex ( int index ){  //Node 返回的是一个地址。   只提供给 addIndex的 所以private
        if (index < 0 || index > this.size()){  // 判断 index合法性 5个元素 起始0 结束4  5号是可以插的，>5不行没有前驱
            throw new RuntimeException("index位置不合法");
        }
        Node cur = this.head;
        while (index-1 != 0) {  // 0--4 插入3 号位子 cur从开始 走1 2 两步
            cur = cur.next;
            index--;
        }
        return cur;
    }
    /**---------------6中间插----------------*/
    public void addIndex(int index,int data) {
        Node node = new Node(data);
        if (index == 0) {                 // 0号插 直接是头插
            addFirst(data);
            return;
        }
        if (index == this.size()) {    // 0---5  5号位子插 就是尾插
            addLast(data);
            return;
        }
        Node cur = searchIndex(index);  //找到了index-1位置的地址
        node.next = cur.next;            //后面绑新的
        cur.next = node;                //新的绑前面
    }


    /**------------判断key元素的前一个地址------------*/
    private Node searchPrev  ( int key ) {
        Node prev = this.head;
        while ( prev.next != null) {    /**若是 prev 走到最后一个 prev.next.data 空指针异常 ;一定是 prev.next !=null   这时候最后结点的data已经被验证了  */
            if (prev.next.data == key ) {
                return prev;                        // 如果每次prev的下一个结点的 data等于 就返回key的前一个结点 prev
            }
            else {
                prev = prev.next;                      // 找不到相等 每次prev就往后走一步
            }
        }
        return null;                        //所以的走完了 也没有找到相等的就返回null
    }
    /**----------7删除第一次出现的key-------*/
    public void remove ( int key ) {

        if(this.head == null ) {   //顺序表为空
            return;
        }
        if (this.head.data == key ) {
            this.head = this.head.next;        //要删除的元素正好是第一个 在头结点的位置
            return;
        } //
        Node prev =  searchPrev  ( key );       //prev结点是删除元素的上一个结点 prev最多走到倒数第二个位置
        if ( prev == null ) {
            System.out.println("没有这个结点");
            return;                       //找不到这个 元素 链表里面没有
        }
        Node del = prev.next;        // 创建一个del结点  代表删除的结点
        prev.next = del.next;    //相当于跳过del结点 舍弃它 链接到下一个; 若删除的是最后一个元素 del的next刚好为null
    }
    /**------------------  8删除出现的多个key--------------- */

    public  void  removeAll (int key ) {
        Node prev = this.head;              //prev 总是在cur的前一个相邻位置
        Node cur = this.head.next;
        while (cur != null ) {          //遍历完整个链表
            if (cur.data == key ) {
                prev.next = cur.next;
                cur =cur.next;                /** 删除完一个要往后挪一个位置 ，方便下次判断cur是不是和key想到 解决了连续key的问题*/
            }
            else {
                prev = cur;                 //每次key和cur不相等 prev和cur就依次往后走一个位置
                cur =cur.next;
            }
        }
        if (this.head.data == key ) {
            this.head = this.head.next;        //要删除的元素正好是第一个 在头结点的位置
        }
    }
    /**--------------9清空链表 释放内存------------*/
    public void clear ( ) {

        this.head = null;      //jvm在回收内存时候 当没有人引用这个对象 这个对象才会被回收
    }

}
