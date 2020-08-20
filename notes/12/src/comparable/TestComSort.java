package comparable;
import java.util.Arrays;
/**
 * @Description:   自定义类型的排序 需要实现接口 并且重写方法；
 *                  当实现了可比较后 ，排序等才可以实现
 * @Author: Cheng
 * @Create: 2020-05-27 13:09
 **/

class StudentP implements Comparable<StudentP>{
    public int age;
    public int score;
    public String name;

    public StudentP(String name,int age,int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }
    @Override
    public int compareTo(StudentP obj) {
            return this.score - obj.score;
    }       /**this - obj 是从小到大排序*/
    @Override
    public String toString() {
        return "StudentP{" +
                "age=" + age +
                ", score=" + score +
                ", name='" + name + '\'' +
                '}';
    }
}
public class TestComSort {
    public static void main(String[] args) {
        StudentP student11 = new StudentP("tom",20,88);
        StudentP student22 = new StudentP("xixi",17,86);
        StudentP student33 = new StudentP("haha",5,99);
        StudentP [] arr = { student11,student22,student33};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
