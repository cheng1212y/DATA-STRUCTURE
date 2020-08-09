import java.util.Arrays;

/**
 * @Description: 手动实现顺序表
 * @Author: Cheng
 * @Create: 2020-08-09 13:13
 **/
public class MyArrayList { //-------------顺序表

    public int [ ] elem;  //  数组类型整型 名字，此时还没分配空间 也可以直接后面写 =int [10]
    public int usedSize;  //  有效的数据个数
    public  static final int capacity= 10;  //------------初始容量只有一份 且不能被修改

    public MyArrayList(  ) {
        this.elem = new int [capacity] ;  //------通过构造方法初始化一下数组，分配了空间。也可以在第一步初始化
        this.usedSize  = 0;


    }


    //isFull 是独立提供给add函数的 ，就设置私有
    private boolean isFull ( ) {  //---------------------提供一个方法 判断数组元素是否为满 ，没有空位子了
        if ( this.usedSize == this.elem.length ) {
            return true;
        }
        return false;
    }
    /**---------------------------增 加一个元素----------------------------*/
    public void add ( int pos, int data) {   //------------pos位置 插入data

        if ( isFull( )  ) {         //---------------判断是否满了，满了数组长度要扩容二倍
            //扩容
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length) ; //------------新的elem指向扩容的2倍数组
        } //指向新的数组           拷贝原数的数组，新数组长度是原理二倍

        //数组最后一个元素紧邻的第一个空位置是可以插的 ，第二个往后不可以，没有前驱
        if ( pos > this.usedSize || pos < 0 ) { //------------检查pos位置是否越界
            return;
        }
        for (int i = usedSize-1; i >= pos ; i--) {  //-------i位置为最后一个元素位置，通过不断向左移动，把i的值赋给i+1
            this.elem[i+1] = this.elem[i];          //直到i的位置越过pos
        }
        this.elem[pos] = data;                  //插入
        this.usedSize++;                        //元素个数加一
    }



    /**--------------------------删 除一个元素----------------------------------------*/
    public void remove ( int toRemove ) {
        int index= search( toRemove);   //---------------调用searc方法找到下标

        if ( index == -1 ) {               //-------------判断一下这个数字是否存在
            System.out.println("没有要删除的数字");
            return;
        }

        for (int i = index; i <this.usedSize-1 ; i++) { //----从让i从删除位子一直往前走， 直到 i < this.usedSize-1 ( 4 个元素 i 到倒数第二个就停下)
            this.elem[i]= this.elem[i+1]; //------------------------更新i[ i ]= [  i+ 1 ] 让后一个给值给前一个
        }
        this.usedSize--;   //--------------------this.usedSize - -   ( 不减减，a [ 3 ] = 12依然在，因为只是赋值，减减才会真正删除最后一个 )
    }




    //---------------------------------------------------------------------
    private boolean isEmpty () {   //---------------提供一个方法给getPos来判断数组是否为空
        return this.usedSize == 0;//不能指为null，null是没有分配内存，反例new一个什么都放，是空数组，但是不为null
    }
    /**--------------------查 给下标求元素-------------------------------------*/
    public int getPos ( int pos ) {
        if( isEmpty()) {                          //  ----判断顺序表是否为空
            throw new RuntimeException("顺序表为空");  //---------- 空就手动抛出一个异常，以为如果返回-1，元素是可能有-1的 不合理
        }
        if ( pos < 0 || pos >= this.usedSize ) {   //---------------------判断pos的位置是否越界 6个元素 拿不到6下标，所以pos>=
            throw new RuntimeException("pos越界,位置不合法");
        }
        return this.elem[pos];
    }



    /**---------------------改 修改元素----------------------------------*/
    public void setPos (int pos ,int value) {
        if ( pos < 0 || pos >= this.usedSize ) {   //---------------------判断pos的位置是否越界 6个元素 拿不到6下标，所以pos>=
            throw new RuntimeException("pos越界,位置不合法");
        }
        this.elem[pos] = value;         //---------------直接value赋值
    }




    /**-------------------查 是否包含某个元素-----------------------------*/

    public boolean contains(int toFind) {
        for (int i = 0; i <this.usedSize ; i++) {
            if ( toFind == this.elem [i]) {
                return true;
            }
        }
        return false;
    }
    /**-----------------查 给元素求位置---------------------------------*/

    public int search (int toFind) {
        for (int i = 0; i <this.usedSize ; i++) {
            if ( toFind == this.elem [i]) {
                return i ;
            }
        }
        return -1;
    }



    /**-------------------打印顺序表------------------------------------*/
    public void display() {
        for (int i = 0; i <this.usedSize ; i++) {
            System.out.print(this.elem[i]+ " ");
        }
    }


    /**-------------获取顺序表的长度------------------------------------*/
    public int  size ( )  {
        return this.usedSize;
    }


    /**--------------------清空顺序表-----------------------------------*/
    public void clear () {
        this.usedSize =0;      //-------------------------------因为打印的时候， i的循环是从this.usedSiz判断的
    }


}
