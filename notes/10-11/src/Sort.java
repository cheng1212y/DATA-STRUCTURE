import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;
/**
 * @Description:                    七大排序
 *
 *                      1、若一个排序是稳定的排序，则可以变为不稳定的
 *                      2、稳定的排序，比较的时候是没有跳跃式的，都是紧接着给下一个
 *                      3、若不稳定排序，无法变为稳定排序
 * @Author: Cheng
 * @Create: 2020-05-22 18:57
 **/
public class Sort {

    /**     1、插入排序
     *      时间：最坏 O(n*n)  最好 O(n)
     *      越有序越快
     *      空间：O (1)
     *      稳定性：稳定
     * */
    public static void insertSort ( int [] array ) {
        int tmp = 0;
        for (int i = 1; i <array.length ; i++) {   /** i 必须遍历到最后一个元素，因为 j 是i前面的 */
            tmp = array[i];
            int j = 0;
            for ( j = i-1; j >= 0; j--) {
                if (array[j] >tmp ) {       /** 加了 = 是不稳定的 */
                    array[j + 1] = array[j];
                }
                else {
                    break;
                }
            }
            //1、因为 j遍历到-1位置
            //2、j号下标小于tmp，break退出
            array[j+1] =tmp;
        }
    }


    /**     2、希尔排序
     *      时间：最坏 O(n*n)  平均 O( n^1.3 )
     *      空间：O (1)
     *      稳定性：不稳定
     * */
    public static void shell(int[] array,int group) {
        int tmp = 0;
        for (int i = group; i <array.length ; i++) {/** i 每次都是加1 会遍历完数组 所以即便是分组不满 5、5、2的情况，最后 两个2也可以被插入排序*/
            tmp = array[i];
            int j = 0;
            for ( j = i-group; j >= 0; j= j-group) {
                if ( array[j] > tmp ) {
                    array[j+group] = array[j];
                }
                else {
                    break;
                }
            }
            array[j+group] = tmp;
        }
    }
    public static  void  shellSort(int[] array) {
        int [] group = { 5,3,1}; //分组情况
        for (int i = 0; i <group.length ; i++) {
            shell( array, group[i]);
        }
    }


    /**     3、选择排序
     *       时间 ：O( n*n )---最好最坏都是
     *       空间：O( 1 )
     *      稳定性：不稳定
     * */
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) { //减不减1 都可
            int j = 0;
            //i从0 位置开始 ，j从i+1位置开始，j要遍历完数组，
            // 若每次发现j号下标小于i下标的值就交换，否则就一直往后走
            for (j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
            }
        }
    }

    /**     4、堆排序
     *      时间： 0( n*log2(n) )
     *      空间：O( 1 )
     *      稳定性：不稳定
     *      排升序要建大堆；排降序要建小堆
     * */
    //向下调整
    public static void adjustDown ( int [] arr, int root, int len   ) {
        int parent = root;
        int child = root*2+1;
        while ( child < len ) {
            if ( child + 1 < len && arr[child] <arr[child+1]) {
                child++;
            }
            if ( arr[child] > arr [parent] ) {
                int tmp = arr[parent];
                arr[parent] = arr[child];
                arr[child] = tmp;
                parent =child;
                child  = 2*parent+1;
            }
            else {
                break;
            }
        }
    }
    //  创建一个堆 ---时间复杂度  O ( log n )
    public static void buildHeap ( int [] arr ) {
        for (int i = (arr.length-1-1)/2; i>= 0 ; i--) {
            adjustDown(arr,i,arr.length);
        }
    }
    public static void heapSort (int [] arr  ) {
        buildHeap ( arr );
        int end = arr.length-1; //最大数换到尾部 再从0树开始向下调整
        while (end > 0) {
            int tmp = arr[0];
            arr[0] = arr[end];
            arr[end] = tmp;
            adjustDown(arr,0,end);
            end--;
        }
    }




    /**     5、冒泡排序
     *      时间： 0( n * n  ) ----优化后加flag 可达到   0( n )
     *      空间：O( 1 )
     *      稳定性：稳定
     * */

    public static void bubbleSort (int [ ] arr ) {
        for (int i = 0; i <arr.length-1 ; i++) {
            for (int j = 0; j <arr.length-1-i; j++) {
                if ( arr [ j+1 ] < arr [j] ) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }
    /** 优化版冒泡排序----------------O( n )   */
//    public static void bubbleSort1(int[] array) {
//        boolean flg = false;
//        //i  表示趟数
//        for (int i = 0; i < array.length-1; i++) {
//            flg = false;
//            for (int j = 0; j < array.length-1-i; j++) {
//                if(array[j] > array[j+1]) {
//                    int tmp = array[j];
//                    array[j] = array[j+1];
//                    array[j+1] = tmp;
//                    flg = true;
//                }
//            }
//            if(flg == false) {
//                return;
//            }
//        }
//    }


    /**     6、快速排序   ---比堆排快 但是空间浪费一点
     *      时间： 最好：0( n*log2(n)  )     最坏：0( n * n )---1、2、3、4、5
     *      空间：最好: O( log2(n) )     最坏： O( n )
     *      稳定性：不稳定
     *      快速排序要快，每次划分序列的时候 如果是均分的，那么效率最高
     * */
    public static void quickSort ( int [] array) {
        quick(array,0,array.length-1);
    }
    public static int partition(int[] array,int low,int high) {
        int tmp = array[low];
        while (low < high) {
            while ( low < high && array[high] >=tmp ) { /** 不取= 会死循环*/
                high--;
            }
            array [ low ] = array[high];
            while (low < high &&  array[low] <= tmp ) {
                low++;
            }
            array[high] = array[low];
        }
        array[low] = tmp; /**tmp 归为到应该的位置*/
        return low;
    }
    public static void quick(int[] array,int left,int right) {
        if(left >= right) {
            return;
        }
        // 优化一：小于100 直接插入
        //        if(right-left+1 <= 100) {
        //            insert_sort(array,left,right);
        //            return;
        //        }
        //优化二：three_num_mid(array,left,right);
        int par =  partition( array,left ,right);  //代表基准值最终停留的下标
        quick(array, left, par - 1);        //递归的找基准
        quick(array, par + 1, right);
    }

    /** 快速排序 优化方式一：当待排序序列的数据个数小于等于100的时候，用直接插入排序*/
    public static void insert_sort(int[] array,int start,int end) {
        int tmp = 0;
        for (int i = start+1; i <= end; i++) {
            tmp = array[i];
            int j;
            for (j = i-1; j >= start ; j--) {
                if(array[j] > tmp) {
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }


    /** 快速排序 优化方式二：三数取中法 */
    public static void three_num_mid(int[] array,int left,int right) {
        //做成：array[mid] <= array[left] <= array[high]
        int mid = ( left + right)/2;
        if(array[left] > array[right]) {
            swap(array,left,right);
        }
        if(array[mid] > array[left]) {
            swap(array,left,mid);
        }
        if(array[mid] > array[right]) {
            swap(array,mid,right);
        }
    }
    public static void swap(int[] array,int i,int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    /**
     * 非递归快排--------------使用一个栈辅助
     *
     * */
    public static void quickSortP(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int left = 0;
        int right = array.length-1;
        int par = partition(array,left,right);
        //判断一下par的左边就只有一个元素 就不需要入栈
        if (par > left+1 ) {
            stack.push(left);
            stack.push(par-1);
        }
        //判断一下par的右边就只有一个元素 就不需要入栈
        if ( par < right -1 ) {
            stack.push(par+1);
            stack.push(right);
        }
        //栈不为空 就往外拿数据
        while ( !stack.empty()) {
            right = stack.pop();
            left = stack.pop();
            par = partition(array,left,right);
            if (par > left+1 ) {
                stack.push(left);
                stack.push(par-1);
            }
            if ( par < right -1 ) {
                stack.push(par+1);
                stack.push(right);
            }
        }
    }






    /**     7、归并排序
     *      时间： 0( n*log2(n) )
     *      空间： O( n )
     *      稳定性：稳定
     * */






    /** --------------归并-----------------非递归 */

    public static void mergeSort(int[] array) {
        for (int gap = 1; gap < array.length; gap *= 2) {
            mergeNor(array,gap);
        }
    }


    public static void mergeNor(int[] array,int gap) {
        int[] ret = new int[array.length];
        int k = 0;//ret的下标
        int s1 = 0;
        int e1 = s1+gap-1;
        int s2 = e1+1;
        int e2 = s2+gap-1 < array.length ? s2+gap-1 :  array.length-1;

        //1、肯定是有两个归并段的
        while (s2 < array.length) {
            //2、对应的s1位置和s2位置进行比较

            //3、上述第2步在比较的过程当中，肯定会有一个下标先走完一个归并段

            //4、判断是谁没走完，把剩下的数据拷贝到结果数组当中

            //5、接着确定新的s1,e1,s2,e2
        }


    }



    public static void main1(String[] args) {
        int [] arr = new int[90_000000];
        Random random = new Random();
        for (int i = 0; i <90_000000 ; i++) {
           // arr[i] = i;
         arr[i] = random.nextInt(90_000000);
        }
        long s = System.currentTimeMillis();
       //insertSort(arr);
       //   shellSort(arr);
       // selectSort(arr);
      // heapSort(arr);
       //bubbleSort ( arr );
     // quickSortP(arr);

        long e = System.currentTimeMillis();
        System.out.println( "排序用时："+(e-s)+"毫秒" );

    }
    public static void main(String[] args) {
       int [ ] arr = {1,2,444,0,5};
        insertSort(arr);
        // shellSort(arr);
       // selectSort(arr);
       // heapSort ( arr  );
       // bubbleSort ( arr );
        //quickSortP(arr);
    System.out.println(Arrays.toString(arr));

    }

}


