/**
 * @Description:
 * @Author: Cheng
 * @Create: 2020-08-18 15:03
 **/
public class Test {
    public static void main(String[] args) {
        int [ ] arr = {27,15,19,18,28,34,65,49,25,37};
        MyHeap myHeap = new MyHeap();
        myHeap.buildHeap(arr);
        myHeap.show (  );
        myHeap.push(1000);
        myHeap.show();


    }
}
