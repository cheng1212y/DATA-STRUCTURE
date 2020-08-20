
/**
 * @Description: 测试堆
 * @Author: Cheng
 * @Create: 2020-05-22 10:52
 **/
public class TestMain {


    public static void main(String[] args) {
        int [ ] arr = {27,15,19,18,28,34,65,49,25,37};
        MyHeap myHeap = new MyHeap();
        myHeap.buildHeap(arr);
        myHeap.show (  );

        myHeap.push(1000);
        myHeap.show();
        myHeap.myHeapSort();
        myHeap.show();

        System.out.println("=========topK===========");
        int [] top = {313,54,8,35,1231,654,6,1431,757,243,68654,2343,86,25,74573,311,7356,123,76742,3,864,2374,525,84732,8648462,745736,84,2 };
        MyHeap myHeap1 = new MyHeap();
        myHeap1.topK( top,4);
        myHeap1.show();
    }

}
