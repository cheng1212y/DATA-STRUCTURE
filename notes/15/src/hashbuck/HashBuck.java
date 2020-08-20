package hashbuck;
/**
 * @Description:  哈希桶
 * @Author: Cheng
 * @Create: 2020-05-29 20:10
 **/
public class HashBuck {
        static class Node {     //内部类的 结点
            public int key;
            public int val;
            public Node next;
            public Node(int key,int val) {
                this.key = key;
                this.val = val;
            }
        }
        /**-----------哈希桶底层数组--------------------*/
        public Node[] array = new Node[10];
        public int usedSize;

    /**------------1、哈希桶中添加操作--------------------*/
    public void put(int key,int val) {
            int index = key % array.length; //哈希函数计算key值的对应在数组中的索引
            for (Node cur = array[index] ;cur != null;cur = cur.next) { //遍历索引位置所挂载的链表
                if(cur.key == key) {
                    //key相同 更新val值
                    cur.val = val;
                    return;
                }
            }
        /**2、尾插法-------------jdk 1.8 使用的尾插法*/
            Node node = new Node(key,val);
            //1、index为空的情况
           Node cur = array[index];
            if (cur == null) {
                node.next = array[index];
                array[index] = node;
                this.usedSize++;
            }
            //2、不为空就 继续挂载结点
            else { //采用尾插法挂载
                 cur = array[index];
                while ( cur.next != null) {
                    cur = cur.next;
                }
                //已经拿到了链表的末尾结点
                cur.next = node;
                node.next = null;
                this.usedSize++;
            }
        /**2、头插法*/
//        Node node = new Node(key,val);
//        node.next = array[index];
//        array[index] = node;
//        this.usedSize++;
            //每次插入的时候需要先判断负载因子，超出就扩容
            if(loadFactor() > 0.75) {
                resize();
            }
        }
    /**-----------------负载因子的计算-----------------------------*/
    public double loadFactor(){
        return this.usedSize*1.0 / this.array.length;
    }
/**-----------------数组的扩容-----------------------------*/
public void resize() {
    Node[] newArray = new Node[2*this.array.length];
    for (int i = 0; i < array.length; i++) {//遍历数组
        Node cur = array[i];
        while (cur != null) {//遍历单链表
            Node curNext = cur.next;//记录下cur的next结点
            int index = cur.key%newArray.length;
            cur.next = newArray[index];
            newArray[index] = cur;
            cur = curNext;
        }
    }
    array = newArray;
}
    /**-----------------2、get方法获得value-----------------------------*/
    public int get(int key) {
        int index = key % array.length;
        Node cur = array[index];
        while (cur != null) {
            if(cur.key == key) {
                return cur.val;
            }
            cur = cur.next;
        }
        return -1;
    }
    public static void main(String[] args) {
         HashBuck hashBuck = new HashBuck();
//        for (int i = 1; i <8; i++) {
//            hashBuck.put(i,i);
//        }
        hashBuck.put(11,99);
        hashBuck.put(11,555);
        hashBuck.put(21,88888888);



        System.out.println(hashBuck.get(11));
        System.out.println(hashBuck.get(21));
    }


}





