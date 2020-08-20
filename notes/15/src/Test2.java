import java.util.Scanner;

/**
 * @Description:
 * @Author: Cheng
 * @Create: 2020-06-01 21:45
 **/
public class Test2 {
    public int count(int[] A, int n) {
        int count = 0 ;
        for (int i = 0; i <n -1; i++) {
            for (int j = i+1; j <n ; j++) {
                if (A[i] > A[j]) {
                    count++;
                }
            }
        }
        return count;
    }


    public static  int max ( int a ) {
        return a/2;
    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while ( scanner.hasNext()) {
            int num = scanner.nextInt();
            if(num !=0){
                System.out.println( max(num));
            }
    }
    }
}
