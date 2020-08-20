import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Description:  优先级队列PriorityQueue 线程不安全
 *                 PriorityBlockingQueue 线程安全的
 *
 *                常用构造方法： PriorityQueue(int initialCapacity,  Comparator<? super E> comparator)
 *
 * @Author: Cheng
 * @Create: 2020-05-22 17:44
 **/



/**  1、PriorityQueue中放置的元素必须要能够比较大小，不能插入无法比较大小的对象，否则会抛出ClassCastException异常
 2. 不能插入null对象，否则会抛出NullPointerException
 3. 没有容量限制，可以插入任意多个元素，其内部可以自动扩容
 4. 插入和删除元素的时间复杂度为 O( log2(n) )
 5. PriorityQueue底层使用了堆数据结构-----------小根堆
 *
 * */
public class TestPriorityQueue {


    public static void main(String[] args) {
        // 创建一个空的优先级队列，底层默认容量是11
        PriorityQueue<Integer> q1 = new PriorityQueue<>();
        // 创建一个空的优先级队列，底层的容量为initialCapacity
        PriorityQueue<Integer> q2 = new PriorityQueue<>(100);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
// 用ArrayList对象来构造一个优先级队列的对象
// q3中已经包含了三个元素
        /**PriorityQueue(Collection <? extends E> c)
         * list 实现了Collection接口 ，且list的类型是 E 类型或者E的子类 ，此处的E要看队列的E是啥
         * */
        PriorityQueue<Integer> q3 = new PriorityQueue<>(list);
        System.out.println(q3.size());
        System.out.println(q3.poll());
        System.out.println(q3.peek());

    }

    public static void main2(String[] args) {
        int[] arr = {4,1,9,2,8,0,7,3,6,5};
// 一般在创建优先级队列对象时，如果知道元素个数，建议就直接将底层容量给好
// 否则在插入时需要不多的扩容
// 扩容机制：开辟更大的空间，拷贝元素，这样效率会比较低
        PriorityQueue<Integer> q = new PriorityQueue<>(arr.length);
        for (int e: arr) {
            q.offer(e);
        }
        System.out.println(q.size()); // 打印优先级队列中有效元素个数
        System.out.println(q.peek()); // 获取优先级最高的元素
// 从优先级队列中删除两个元素之和，再次获取优先级最高的元素
        q.poll();
        q.poll();
        System.out.println(q.size()); // 打印优先级队列中有效元素个数
        System.out.println(q.peek()); // 获取优先级最高的元素
        q.offer(0);
        System.out.println(q.peek()); // 获取优先级最高的元素
// 将优先级队列中的有效元素删除掉，检测其是否为空
        q.clear();
        if(q.isEmpty()){
            System.out.println("优先级队列已经为空!!!");
        }
        else{
            System.out.println("优先级队列不为空");
    }

    }







    public static void main1(String[] args) {

        //通过接口 和本身都可以new一个
        Queue<Integer> queue1 = new PriorityQueue<Integer>();
        PriorityQueue priorityQueue = new PriorityQueue();

        priorityQueue.add(122);
        priorityQueue.add(22);
        priorityQueue.add(1);
        priorityQueue.add(14);
        priorityQueue.add(16);
        priorityQueue.add(999);
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());


    }
}
