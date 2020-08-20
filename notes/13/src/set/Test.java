package set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @Description:    set的方法   纯 key 模型，即我们 Set 要解决的事情，只需要判断关键字在不在集合中即可，没有关联的 value；
 * @Author: Cheng
 * @Create: 2020-05-28 17:39
 **/
public class Test {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>() ;  set.add("Hello");
// 重复元素
        set.add("Hello");
        set.add("cat");
        set.add("Hello");
        set.add("Java");     //set中不存在重复的元素
        System.out.println(set);
        //迭代器
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
