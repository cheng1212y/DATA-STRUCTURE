package practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @Description:   十万数据中 找到第一个重复的数据
 * @Author: Cheng
 * @Create: 2020-05-28 17:46
 **/
public class Test1 {
    public static void main(String[] args) {
        Random random = new Random(6000);
        ArrayList<Integer> list = new ArrayList<>();
//拿到十万数据
        for (int i = 0; i <10_0000 ; i++) {
            list.add(random.nextInt(6000));
        }

        Set<Integer> set = new HashSet<>();
        for (Integer val :list) {
            if(set.contains(val)) {
                System.out.println("找到了第一个重复的元素：" + val);
                return;
            }else {
                set.add(val);
            }

        }


    }
}
