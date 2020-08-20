package insideclass;

/**
 * @Description:   实例内部类--->看作是一个普通的实例数据成员
 * @Author: Cheng
 * @Create: 2020-05-27 17:25
 **/

class OuterClass {
    public int data1 =11;
    public static int data2 =22;
    public int data6 =66;
    public void func (){
        System.out.println("outter类的方法");
    }

    //实例内部类：--->看作是一个普通的实例数据成员
    class InterClass {
        public int data1= 1010;
        public int data3=100;

        //加上一个 final 在编译的时候就初始化了 就不依赖与对象
        public static final int val = 9; /**  实例内部类相当于实例数据成员，而它实例数据成员的初始化依赖于外部对象的引用 ，
         而static的东西不依赖于对象，static想早点被初始化，但是Interclass还在等外部对象的引用。*/

        public void func (){
            System.out.println(data1);  /**重名的属性时候，局部优先会访问内部类自己的*/
            System.out.println(OuterClass.this.data1);  /**重名的时候，要想访问外部类的属性，需要通过 外部类名+this*/
            System.out.println(data2);   //-------内部类可以访问外面的属性
            System.out.println(data3);
            System.out.println("outter类的方法");
        }
    }
}
public class Test2 {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        OuterClass.InterClass interClass = outerClass.new InterClass(); //通过外部类的引用调用内部类的对象
        interClass.func();  /**默认调用的都是内部类的属性与方法 */
    }
}
