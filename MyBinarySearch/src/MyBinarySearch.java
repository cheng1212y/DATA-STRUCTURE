/**
 * @Description: 二分查找
 * @Author: Cheng
 * @Create: 2020-08-22 22:31
 **/
public class MyBinarySearch {
        public static int find (int [] arr,int k) {
            int left = 0;
            int right = arr.length-1;
            int mid  = 0;
            while (left <= right) {      //一定是<=  找最后一位 l r 在一起相遇，m的位置还没到位
                mid = (left+right)>>>1;
                if (k>arr[mid]) {
                    left = mid + 1 ;
                }
                else if (k<arr[mid]) {
                    right = mid - 1 ;
                }
                else {
                    return mid;
                }
            }
            return -1;
        }
    public static void main(String[] args) {
        int [ ] arr = {1,2,3,4,5,99};
        System.out.println(find(arr, 3));
    }
    }
