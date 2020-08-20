import java.util.Scanner;
import java.util.Stack;
import java.util.Scanner;
/**
 * @Description:
 * @Author: Cheng
 * @Create: 2020-06-03 10:59
 **/
public class Test3 {

    /** 2、字符串中找最长的连续数字 并打印这一串*/
        public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);
            while(scanner.hasNext()){
                String str=scanner.nextLine();
                int max=0;
                int count=0;
                int end=0;
                for(int i=0;i<str.length();i++){
                    if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
                        count++;
                        if(max<count){
                            max=count;
                            end=i;
                        }
                    }
                    else{
                        count=0;
                    }
                }
                System.out.println(str.substring(end-max+1,end+1));
            }
        }








 /**1、括号匹配问题*/
    public static boolean chkParenthesis(String A, int n) {
        if ( n % 2 == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if (c == '(') {
                stack.push(c);           //是左括号就压栈
            }

            //2、不是左括号的情况
            else {
                if (stack.empty()) {
                    return false;  //没有左括号 只有右括号
                }

                char tmp = stack.peek();
                if (tmp == '(' && c == ')') {
                    stack.pop();
                } else {
                    return false;  // 左右括号不匹配
                }
            }
        }

        if ( stack.empty()) {
            return true;
        }
        return false;
    }
}
