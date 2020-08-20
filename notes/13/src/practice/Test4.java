package practice;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @Description:  找到只出现一次的元素
 * @Author: Cheng
 * @Create: 2020-05-28 18:00
 **/
public class Test4 {

    public int singleNumber(int[] nums) {

        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if(hashSet.contains(nums[i])) {
                hashSet.remove(nums[i]);
            }else {
                hashSet.add(nums[i]);
            }
        }
        Iterator<Integer> it = hashSet.iterator();
        return it.next();
    }
}
