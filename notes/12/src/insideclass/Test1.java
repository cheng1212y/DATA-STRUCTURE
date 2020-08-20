package insideclass;

/**
 * @Description:  匿名内部类
 * @Author: Cheng
 * @Create: 2020-05-27 17:07
 **/

class Animal {

    public void func ( ) {
        System.out.println(" Animal----------func");
    }
}
public class Test1 {
    public static void main(String[] args) {
        new Animal(){
            @Override
            public void func() {
                System.out.println(" 匿名内部类的重写方法");
            }
        }.func();
    }




    public static void main1(String[] args) {
        new Animal( ).func();  //匿名对象调用自己的方法
    }


}
