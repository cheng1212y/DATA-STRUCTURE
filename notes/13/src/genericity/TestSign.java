package genericity;

import java.util.ArrayList;

/**
 * @Description:      通配符
 * @Author: Cheng
 * @Create: 2020-05-28 15:19
 **/


class GenericSS {
    public static <T>  void show ( ArrayList <T> list ) {
        for ( T val: list  ) {
            System.out.print( val + " ");
        }
        System.out.println();
    }

    /**
     * 1、使用通配符号之后 < > 里面是 ？；
     * 2、其中的每一次元素不在是T 而是Object；
     * 3、void前面不加T
     * 4、通配符也是一种泛型
     * 5、 通配符：也是一种泛型。
     * 通配符一把用于读取  add(?)
     * 泛型一般用于写入  add(T)
     * 通配符既有上界     也有下界
     * */
    public static   void show2 ( ArrayList <?> list ) {
        for ( Object val: list  ) {
            System.out.print( val + " ");
        }
        System.out.println();
    }
}
public class TestSign {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(612);
        list.add(121);
        GenericSS.show2(list);
    }
}
