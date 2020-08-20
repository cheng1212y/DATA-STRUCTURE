import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description:  使用Collections 的sort 对list排序
 * @Author: Cheng
 * @Create: 2020-05-13 17:56
 **/
public class Test3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(32);
        list.add(6);
        list.add(1);
        System.out.println(list);
        System.out.println("=============");
        Collections.sort(list);

        System.out.println(list);
    }
}
