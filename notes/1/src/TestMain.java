/**
 * @Description:
 * @Author: Cheng
 * @Create: 2020-05-13 13:36
 **/

class Person {

}

public class TestMain {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(111);
        myArrayList.add(222222);
        myArrayList.add(333333);
       // myArrayList.add("sadsad"); 只能放整形 new的是Integer
        int val = myArrayList.getVal(1);  //取数据不需要强制类型转换
        System.out.println(val);

        System.out.println("========================");

        Person person = new Person();
        System.out.println(person);
        System.out.println( myArrayList);


    }
}
