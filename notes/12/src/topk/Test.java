package topk;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description:   找出 数据中 前k个的 最小数---------建立的是大根堆
 *                 但是优先级队列默认的是 小根堆，解决的办法是传入比较器
 * @Author: Cheng
 * @Create: 2020-05-27 15:53
 **/

/**方法一 在外部定义比较器的类*/
//class MyComparator implements Comparator<Integer> {
//    @Override
//    public int compare(Integer o1, Integer o2) {
//        return o2-o1;       //o2-o1  将按照从大到小排序
//    }
//}
public class Test {
    public static Integer[] topK(int[] array,int k) {

       /** 方法一*/
        //MyComparator myComparator = new MyComparator();
        // PriorityQueue<Integer> maxHeap = new PriorityQueue<>(myComparator); //传入比较器
        /** 方法二  不需要在外部定义比较器的列    匿名内部类 */
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;       //o2-o1  将按照从大到小排序
//            }
//        });
        /** 方法三   lambda表达式 jdk1.8新增语法  V1 v2 是参数 -> 指向的是返回值*/
        PriorityQueue<Integer> maxHeap = new PriorityQueue< >(( v1,v2)->v2-v1);
        for (int i = 0; i < array.length; i++) {
            if(maxHeap.size() < k) {
                maxHeap.offer(array[i]);
            }else {
                Integer val = maxHeap.peek();     //为了判断val不为空 才装箱
                if(val != null && val > array[i]) {
                    maxHeap.poll();
                    maxHeap.offer(array[i]);
                }
            }
        }
        Integer[] ret = new Integer[k];
        for (int i = 0; i < k; i++) {
            int v = maxHeap.poll();
            ret[i] = v;
        }
        return ret;
    }
    public static void main(String[] args) {
        int[] array = {3,2,7,8,18,0,15};
        Integer[] ret = topK(array,4);
        System.out.println(Arrays.toString(ret));
    }
}
