import java.util.Scanner;

/**
 * @Description:
 * @Author: Cheng
 * @Create: 2020-05-31 20:21
 **/
public class Main {

    public static boolean func ( String str ) {
        char [] arr = str.toCharArray();
        int left = 0;
        int right = arr.length-1;
        boolean f = true;
        while (left<right) {
            if ( arr[left] == arr[right]) {
                left++;
                right--;
            }
            else {
                f = false;
                break;
            }
        }
        if ( f== true) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuffer AS = new StringBuffer();
        StringBuffer BS = new StringBuffer();
        String A = scanner.nextLine();
        String B = scanner.nextLine();
        int count = 0;
        for (int i = 0; i <= A.length()     ; i++) {
            StringBuffer sb = new StringBuffer(A);
            sb.insert(3,B);
            String s = sb.toString();
            if (func(s)) {
                count++;
            }

        }
        System.out.println(count);
    }
}
