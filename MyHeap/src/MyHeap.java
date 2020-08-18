import java.util.Arrays;

/**
 * @Description:   手动实现堆--------底层数组   提供push pop peek show 方法
 * @Author: Cheng
 * @Create: 2020-08-18 15:02
 **/
/**
 * 如果i为0，则i表示的节点为根节点，否则i节点的双亲节点为 (i - 1)/2
 * 如果2 * i + 1 小于节点个数，则节点i的左孩子下标为2 * i + 1，否则没有左孩子
 * 如果2 * i + 2 小于节点个数，则节点i的右孩子下标为2 * i + 2，否则没有右孩子
 * */
public class MyHeap {

    public int [ ]  elem;      //堆的底层是数组
    public  int usedSize;

    public MyHeap( ) {
        this.elem =  new int[ 10 ]; //初始容量为10
        this.usedSize = 0;
    }

    /**-----------------向下调整为大根堆---------O ( log2(n) )-----*/
    /**-----------------向下调整为小根堆---------只需要将比较的两个符号反调整-----*/

    public void adjustDown ( int root, int len ) { //len是数组长度，第一次root尾结点的父节点4(3、2、1)
        int parent = root;
        int child = root*2 +1;
        while ( child < len ) {  // 如果2 * i + 1 小于节点个数，则节点i的左孩子下标为2 * i + 1，否则没有左孩子
            if ( child + 1 < len && this.elem[child]< this.elem[child+1]) { //存在右孩子且比左大
                child++;  //最大值是右孩子
            }
            //此时的child表示最大值下标
            if (this.elem[child] > this.elem[parent]) {  //child>parent 需要调整为大根堆
                int tmp = this.elem[child];
                this.elem[child]= this.elem[parent];
                this.elem[parent] = tmp;
                /** parent 依然要向下去看 子树是否因为本次调整而不是大根堆*/
                parent = child;
                child = 2*parent +1;
            }
            else {
                break;  //孩子结点小于根节点
            }
        }
    }
    /** 1、----------创建一个堆-----------O(n)---*/
    public void buildHeap ( int [] array ) {
        for (int i = 0; i <array.length ; i++) {
            this.elem[i] = array[i];    //将数组中的每一个元素拷贝到堆数组中
            this.usedSize++;
        }
        //1、数组长度减1 是尾元素下标
        //2、如果i为0，则i表示的节点为根节点，否则i节点的双亲节点为 (i - 1)/2
        //i：每棵子树的根节点下标
        for (int j = (this.usedSize-1-1)/2; j >=0 ; j--) {
            adjustDown(j,this.usedSize ); //每一颗子树都要向下调整
        }
    }


    /** 2、----------push 堆中插入元素----------向上调整----*/
    public void push ( int val ) {
        if (isFull()) {      //若数组满了，需要二倍扩容
            this.elem = Arrays.copyOf(this.elem,this.elem.length*2);
        }
        //插入元素到数组末尾
        this.elem[this.usedSize] = val;
        this.usedSize++;
        adjustUp ( this.usedSize-1 ); //长度-1 拿到末尾元素的下标
    }
    /**-----------向上调整-----------*/
    public void adjustUp ( int child ) {
        int parent = (child-1)/2;
        while ( child > 0 ) {    //结束条件
            //大于的时候 需要向上调整为 大根堆
            if (this.elem[child] > this.elem[parent]) {
                int tmp = this.elem[child];
                this.elem[child]= this.elem[parent];
                this.elem[parent] = tmp;
                child =  parent;      //一直往上走 和变为大根堆不一样 此时调整位置以下已经是大根堆 ，不用往下看
                parent = ( child-1 ) / 2;
            }
            else {
                break;//孩子结点比根节点小 就不需要调整了
            }
        }
    }
    public boolean isFull() {  //判断数组是否已经满了
        return this.usedSize == this.elem.length;
    }


    /** 3、----------pop 堆的删除-------删除堆顶元素----向下调整---*/

    private boolean isEmpty ( ) { //判断是否为空堆
        return this.usedSize == 0;
    }
    public  void pop ( ) {
        if (isEmpty()) {
            return;
        }
        //0位置和末尾元素交换
        int tmp = this.elem[0];
        this.elem[0]= this.elem[this.usedSize-1];
        this.elem[this.usedSize-1] = tmp;
        //删除堆尾
        this.usedSize -- ;
        // 其他的树都是大堆 只有0号树不是大堆 开始向下调整
        adjustDown( 0 ,this.usedSize); //传去的是数组的长度
    }


    /** 4、----------拿到堆头元素-------*/
    public  int peek () {
        if ( isEmpty()) {
            return -1;
        }
        return this.elem[0];
    }

    public void show() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }

}








