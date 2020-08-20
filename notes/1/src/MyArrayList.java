import java.util.Objects;

/**
 * @Description:
 * @Author: Cheng
 * @Create: 2020-05-13 12:50
 **/

public class MyArrayList <T>  {
    public T [] elem;
    public int usedSize;

    public MyArrayList() {
        //this.elem =  new T[10];
        this.elem = (T[]) new Object[10];  //elem的类型是T 所以要强制类型转换
        this.usedSize = 0;
    }
    //默认放到数组最后
    public void add(T val) {
        this.elem[this.usedSize] = val;
        this.usedSize++;
    }
    public T getVal(int pos) {
        return this.elem[pos];
    }

    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        //myArrayList.add("hello"); //报错
        myArrayList.add(99);
        myArrayList.add(66);
        int a = myArrayList.getVal(0);//正确
    }

}
