import java.util.PriorityQueue;

/**
 * @Description:
 * @Author: Cheng
 * @Create: 2020-05-31 14:13
 **/



public class Test {

    public static void main(String[] args) {
        int [] arr = { 1,3,5,2,3};
        System.out.println(findKth(arr, 5, 3));
    }
    public static int findKth(int[] a, int n, int K) {
        // write code here

        PriorityQueue<Integer> queue = new PriorityQueue<>( (v1,v2)->v2-v1);
        for (int i = 0; i < n ; i++) {
            queue.add( a[i]);
        }

        for (int i = 1; i < K ; i++) {
            if ( i != K  ) {
                queue.poll();
            }
        }
        int ret = queue.peek();
        return ret;
    }
}
