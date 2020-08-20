package practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * @Description:  10W数据的去重----------利用Set不能够存放重复的元素
 * @Author: Cheng
 * @Create: 2020-05-28 17:54
 **/
public class Test2 {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10_0000; i++) {
            list.add(random.nextInt(6000));
        }
        HashSet<Integer> set = new HashSet<>();
        for (Integer val : list) {
            set.add(val);
        }
        System.out.println(set);


    }
}
