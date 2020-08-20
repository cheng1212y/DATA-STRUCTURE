package map;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:     Map 方法的展示
 *                                      Key-Value 模型，即我们 Map 要解决的事情，需要根据指定 Key 找到关联的 Value。
 * @Author: Cheng
 * @Create: 2020-05-28 17:20
 **/
public class Test {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>() ;
        map.put(1,"hello") ;
/**key重复就会打印更新的key对应的val*/
        map.put(1,"hello") ;
        map.put(3,"hi") ;
        map.put(3,"Java") ;
        map.put(2,"c") ;
        System.out.println(map) ;
// 根据key取得value
        System.out.println(map.get(2));
        System.out.println(map.get(3));
// 查找不到返回null
        System.out.println(map.get(99));
// 打印所有的 key
        for (Integer key : map.keySet()) {
            System.out.println(key);
        }
// 打印所有的 value
        for (String value : map.values()) {
            System.out.println(value);
        }
// 按 key-value 映射关系打印

/**     map.EntrySet 是最外层的大圈集合
        每一个entry就是打包放在Set集合中的小圈，每个entry包含了 v和k
        每个小包的类型是 Map.entry
 */
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
}
}
