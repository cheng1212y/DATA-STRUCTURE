package comparator;

/**
 * @Description:      comparator 比较器
 * @Author: Cheng
 * @Create: 2020-05-27 14:56
 **/

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *          /返回值:
 *           < 0: 表示 o1 指向的对象小于 o2 指向的对象
 *          == 0: 表示 o1指向的对象等于 o2 指向的对象
 *          > 0: 表示 o1指向的对象大于 o2 指向的对象
 * */
class Person {
    public int age;
    public int score;
    public String name;

    public Person(String name,int age,int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }
    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", score=" + score +
                ", name='" + name + '\'' +
                '}';
    }
}
public class Test {



    /**---------------3、优先级队列添加自定义类型 ----------*/

    public static void main (String[] args) {


        AgeComparator ageComparator = new AgeComparator();
        /**         比较器中写  o2 - o1 就是默认为大堆存放 */
        PriorityQueue< Person> queue = new PriorityQueue<>(ageComparator);

        queue.add( new Person("tom", 20, 88) );
        queue.add( new Person("xixi", 17, 96));
        queue.add( new Person("haha", 5, 99));
        System.out.println(queue.peek());


    }







    /**-----------2、通过比较器 进行数组排序*/
    public static void main2 (String[] args) {
        Person student11 = new Person("tom", 20, 88);
        Person student22 = new Person("xixi", 17, 86);
        Person student33 = new Person("haha", 5, 99);
        Person[] arr = {student11, student22, student33};

        /** 通过sort方法中传入比较器  也可以进行引用类型的排序
         *  o1 减去 o2 是从小到大排序
         * */
        AgeComparator ageComparator = new AgeComparator();
        Arrays.sort(arr,ageComparator);


        System.out.println(Arrays.toString(arr));

    }






    /**---------------1、比较器比较大小*/
    public static void main1 (String[] args) {
        Person person1 = new Person("baozi",8,89);
        Person person2 = new Person("cat",6,66);
        AgeComparator ageComparator = new AgeComparator();
        if ( ageComparator.compare(person1,person2) >0) {     //大于0就是第一个比第二个参数大
            System.out.println("第一个大");
        }
        ScoreComparator scoreComparator = new ScoreComparator();

        System.out.println(scoreComparator.compare(person1, person2));
    }
}
