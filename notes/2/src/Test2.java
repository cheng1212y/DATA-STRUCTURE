import java.util.ArrayList;
import java.util.List;

/**
 * @Description: String s1 = "Welcome to my school";   String s2 = "come";    删除是s1 中出现的上
 * @Author: Cheng
 * @Create: 2020-05-13 17:56
 **/
public class Test2 {
    public static  List<Character> func ( String s1 ,String s2) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i <s1.length() ; i++) {
            char ch = s1.charAt(i);
            if (!s2.contains(ch+"")) {     // 字符拼接上""就是字符串
                list.add(ch);
            }
        }
            return list;                    //返回的是一个 List<Character>类型
    }
    public static void main(String[] args) {
        String s1 = "Welcome to my school";
        String s2 = "come";
        List<Character>  ret =  func( s1,s2);
        for ( char c: ret) {
            System.out.print(c);
        }
    }
}
