import java.util.ArrayList;
import java.util.List;

/**
 * @Description:  List相关方法的使用
 * @Author: Cheng
 * @Create: 2020-05-13 14:22
 **/
public class TestList {



    /** boolean addAll(Collection<? extends E> c) 尾插 c 中的元素
     参数的类型是 Collection<? extends E>  ，形参是 c
     addAll 传的参数两个条件：1、一定是实现了Collection接口的， ？是通配符
                              2、类型一定是 E的子类或者本身*/

    /** subList 是一个浅拷贝  会影响原来的值*/


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("baozi");
        list.add("嘻嘻");
        list.add("haha");
        list.add(1,"fish");
        list.remove("Hello");
         String s = list.remove(0); //删除下标0的元素 返回值E类型 此处是String
        System.out.println(s);
        String r = list.get(0);
        System.out.println(r);
        list.set(1,"哈哈哈"); //set相当于是更新只能设置已有的位置
        System.out.println(list);
        System.out.println(list.contains("baozi"));
        System.out.println(list.indexOf("haha"));
        System.out.println(list);

        System.out.println( "--------subList------------" );
        //  [baozi, 哈哈哈, haha]
        List<String> ret = list.subList(0,2); //截取部分的
        System.out.println(ret);   //[baozi, 哈哈哈]
        System.out.println(list);

        ret.set(0,"猫咪");
        System.out.println(ret);
        System.out.println(list);







        System.out.println("=================");
        List<String> list1 = new ArrayList<>();
        list1.add("java");
        list1.add("Cat");

        list.addAll(list1);    // new ArrayList<>()实现了Collection接口；且此时的是String 原来的E也是String
        System.out.println(list);








    }

}