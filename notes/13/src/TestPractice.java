import java.util.*;

/**
 * @Description:
 * @Author: Cheng
 * @Create: 2020-05-26 20:31
 **/
public class TestPractice {

        public int singleNumber(int[] nums) {
        Set< Integer> set = new HashSet<>();
        for (  int a :  nums) {
            if ( ! set.contains( a )) {
                set.add(a);
            }
            else {
                set.remove(a);
            }
        }
        //使用迭代器
        Iterator<Integer> iterator = set.iterator();
       // return iterator.next();
            return 1 ;
    }

    /**
     * 1、找出10W个数据当中，第一个重复的元素。
     * @param args
     */
    public static void main1(String[] args) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(7));
        }
        System.out.println(list);
        Set <Integer> set = new HashSet<>();
        int j =0;
        for ( j = 0; j <10 ; j++) {
            if ( ! set.contains( list.get(j)  )) {
                    set.add(list.get(j));
            }
            else {
                break;
            }
        }
        System.out.println( list.get(j));
    }
}
