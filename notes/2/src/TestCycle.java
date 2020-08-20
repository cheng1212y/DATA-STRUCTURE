import java.util.ArrayList;
import java.util.List;

/**
 * @Description:  杨辉三角    杨辉三角的公式 ： [ i-1,j ]+[ i - 1 , j - 1 ] =  [ i , j ]
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * @Create: 2020-05-14 13:01
 **/
public class TestCycle {
    public  static  List<List<Integer>> generate(int numRows) {

        List<   List<Integer>  > ret = new ArrayList<>();

        if (numRows == 0) {
            return ret;
        }

        /** 1、 第零行的 先添加一个1*/
        ret.add( new ArrayList<>());
        ret.get(0).add(1);

        /** 2、添加没行除去首尾1 的地方*/
        for (int i = 1; i < numRows ; i++) {

            List <Integer> curRow = new ArrayList<>(); //每行的第一个 先添加一个1
            curRow.add(1);

            List <Integer> prevRow = ret.get(i-1); //拿到i的前一行

            for (int j = 1; j <i ; j++) {

                int x = prevRow.get( j ); //前一行的j位置
                int y= prevRow.get( j -1 );//前一行的j-1位置

                curRow.add( x + y );   //中间添加成功                         [ i-1,j ]+[ i - 1 , j - 1 ] =  [ i , j ]
            }

            curRow.add(1);   //每行的最后一个先添加一个1
            /** 3、添加没行到总的 ret中*/
            ret.add(curRow);
        }
        return ret;
    }


    public static void main(String[] args) {
        List<List<Integer>> ret =   generate( 3);
        System.out.println(ret);
    }

}
