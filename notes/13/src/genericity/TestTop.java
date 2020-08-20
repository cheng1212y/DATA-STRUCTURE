package genericity;

/**
 * @Description:            泛型的上界     泛型无下界
 *                  如果没有上界，泛型就会被擦除为Object，但是Object未实现Comparable接口，就不能比较
 * @Author: Cheng
 * @Create: 2020-05-28 14:30
 **/



/**
 * 写一个泛型类，包含一个方法。该方法是找到数组当中的最大值。
 *  写一个方法，该方法传入参数T[] ，找到最大值并且返回
 *
 *              1、T extends Comparable<T>  上界
 *              2、T 一定是实现了 Comparable接口的
 *              3、下界？？泛型没有下界。
 */

/**  如果没有上界，泛型就会被擦除为Object，但是Object未实现Comparable接口，就不能比较*/
class Generic <T extends Comparable<T>> { /** 实现接口后就可以比较 */
    public T  max ( T [] arr ) {
        T ret = arr[0];
        for (int i = 0; i <arr.length ; i++) {
            if (  arr[i].compareTo(ret) > 0 ) { //实现了接口就可以进行比较了
                ret = arr[i];
            }
        }
        return ret ;
    }
}
public class TestTop {
    public static void main(String[] args) {
        Integer [] arr = { 1,34,5,631,2,73,};
        Generic<Integer> generic = new Generic<>();
        System.out.println( generic.max(arr));


        //不用new对象  比较泛型
        String  [ ]  str = {"adad","fafa","fafgh" };
        System.out.println( GenericP.maxP(str));

    }
}

/**  普通类中 含有泛型的静态方法
 *
 * 第二种方法不需要 new对象的 比较  通过把泛型类中的方法改为static 加上一长串，
 * 类型的推导 根据实参的类型 ----->推导出形参的类型 就知道T是什么
 *
 * */
class GenericP { /** 实现接口后就可以比较 */
    public  static <T extends Comparable<T> >   T  maxP ( T [] arr ) {
        T ret = arr[0];
        for (int i = 0; i <arr.length ; i++) {
            if (  arr[i].compareTo(ret) > 0 ) { //实现了接口就可以进行比较了
                ret = arr[i];
            }
        }
        return ret ;
    }
}


