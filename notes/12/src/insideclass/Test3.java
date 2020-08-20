package insideclass;

/**
 * @Description:   静态内部类
 * @Author: Cheng
 * @Create: 2020-05-27 21:30
 **/

class OuterClassP {
    public int data1 = 1;
    public static int data2 = 2;
    private int data4 = 4;
    /**
     * 静态内部类当中 不能访问外部类的非静态的数据成员;因为静态的先被加载
     * 我非要进行访问怎么办？
     */
    static class InnerClassP {
        public int data3 = 3;
        public int data1 = 1111;

        /** 通过构造方法，传一个外部类的对象的引用,因为data1和4依赖于外部类的对象访问*/
        public OuterClassP out;
        public InnerClassP( OuterClassP out ) {
            this.out = out;
        }
        public void func() {
            System.out.println(this.out.data1); /** 访问的是外部类的非静态数据成员*/
            System.out.println(data2);  //静态的内部类可以访问外部的静态属性
            System.out.println(data3);
            System.out.println(data1); /** 访问的是自己的数据成员*/
        }
    }
}
public class Test3 {
    public static void main(String[] args) {
        OuterClassP outerClassP = new OuterClassP();
        //如何拿到静态类的对象?
        // 静态内部类 看成类的静态属性 通过类名访问
        OuterClassP.InnerClassP innerClassP = new OuterClassP.InnerClassP(outerClassP);
        innerClassP.func();
    }

}
