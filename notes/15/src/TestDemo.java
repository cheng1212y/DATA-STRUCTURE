import java.util.*;

/**
 * @Description:
 * @Author: Cheng
 * @Create: 2020-06-03 19:37
 **/
public class TestDemo {


    /** 暴力求 一个数和最近的斐波那契的差*/
    public  static  long fun ( int ret) {
        List<Long> list = new ArrayList<>();
        list.add(0L);
        list.add(1L);
        long  a = 0L;
        long  b = 1L;
        long  c = 0L;
        for (int i = 0; i < 40; i++) {
            c = a+b;
            a = b;
            b = c;
            list.add(c);
        }
        int target = 0;
        for (int j = 0; j <40 ; j++) {
            if (list.get(j)<ret && list.get(j+1)>ret) {
                target = j;
                break ;
            }

        }
        return Math.min(ret-list.get(target), list.get(target+1)-ret );
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int  ret = scanner.nextInt();
        System.out.println( fun(ret));
    }


    /** 2、牛牛做料理*/
    public static void main1(String[] args) {
        Scanner cin = new Scanner(System.in);
        HashSet<String> martic = new HashSet<String>();
        while(cin.hasNext()){
            martic.add(cin.next());
        }
        int Number = martic.size();
        System.out.println(Number);
    }
}
