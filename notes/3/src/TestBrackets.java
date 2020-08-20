import java.util.Stack;

/**
 * @Description:       左右括号匹配问题
 * @Author: Cheng
 * @Create: 2020-05-14 18:58
 **/
public class TestBrackets {
    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid(s));
    }

    public static  boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);           //是左括号就压栈
            } else {
                //1、判断栈是否为空
                if (stack.empty()) {
                    System.out.println("右括号比左括号多 左边没有括号");
                    return false;
                }
                //拿到栈顶元素
                char c1 = stack.peek();
                if (c1 == '(' && c == ')' || c1 == '[' && c == ']' || c1 == '{' && c == '}') {
                    stack.pop();  //相等就弹出栈顶元素
                } else {
                    System.out.println("左右括号不匹配");
                    return false;
                }
            }
        }
        if (!stack.empty()) {
            System.out.println(" 左括号比右括号多了");
            return false;
        }
        return true;
    }

}
