package practice;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @Description:   坏掉的键盘 打字
 * 链接：https://www.nowcoder.com/questionTerminal/f88dafac00c8431fa363cd85a37c2d5e
 * 输入在2行中分别给出应该输入的文字、以及实际被输入的文字。每段文字是不超过80个字符的串，由字母A-Z（包括大、小写）、数字0-9、
 * 以及下划线“_”（代表空格）组成。题目保证2个字符串均非空。
 * 输出描述:
 * 按照发现顺序，在一行中输出坏掉的键。其中英文字母只输出大写，每个坏键只输出一次。题目保证至少有1个坏键。
 * 示例1
 * 输入
 *              7_This_is_a_test
 *              _hs_s_a_es
 * 输出
 *                      7TI
 * @Author: Cheng
 * @Create: 2020-05-28 19:27
 **/
public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expected = scanner.nextLine();//7_This_is_a_test
        String actual = scanner.nextLine();//_hs_s_a_es
        //1、把实际的字符转换为大写存放到集合当中
        HashSet<Character> setActual = new HashSet<>();
        for (char s : actual.toUpperCase().toCharArray()) {
            setActual.add(s);
        }
        HashSet<Character> retBroken = new HashSet<>();
        for (char c :   expected.toUpperCase().toCharArray()) {
            if ( !setActual.contains(c) && !retBroken.contains(c) ) {
               System.out.print(c);
               retBroken.add(c); // 添加之后 就不会打印重复的元素
            }
        }
    }
}
