package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Description:            统计10W数据中 重复的数字是谁且出现了多少次？
 *                           拿一个数据 判断是否存在Map中
 * @Author: Cheng
 * @Create: 2020-05-28 17:56
 **/
public class Test3 {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10_0000; i++) {
            list.add(random.nextInt(6000));
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        //key --> 关键字重复的数字          5
        //value--> 重复的数字出现的次数     7
        for (Integer key : list) {
            if(map.get(key) == null) {
                map.put(key,1);
            }else {
                Integer val = map.get(key);
                map.put(key,val+1);
            }
        }

        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey()+"这个数字出现了"+entry.getValue()+"次！");
        }
    }
}
