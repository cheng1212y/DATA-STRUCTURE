package comparable;

/**
 * @Description:          自定义类型的比较大小
 *                        1、实现Comparable接口  后面写< 里面是比较的类型>
 *                        2、重写comparTo方法，谁调用comparTo谁就是this ,传进去的参数是 obj
 *                        缺点：每次业务不同  需要去修改类本身。
 * @Author: Cheng
 * @Create: 2020-05-27 12:50
 **/

/**
 *          /返回值:
 *           < 0: 表示 this 指向的对象小于 o2 指向的对象
 *          == 0: 表示 this指向的对象等于 o2 指向的对象
 *          > 0: 表示 this 指向的对象等于 o2 指向的对象
 * */
class Student implements Comparable<Student>{
    public int age;
    public int score;
    public String name;

    public Student(String name,int age,int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }
    @Override
    public int compareTo(Student obj) {
        return this.age - obj.age;//自定义类型的比较需要实现接口 重写方法
    }
}
public class TestComparTo {
    public static void main(String[] args) {
        Student student1 = new Student("baozi",16,89);
        Student student2 = new Student("cat",26,66);
        Student student3 = new Student("dog",6,96);
        if (   student1.compareTo(student2 ) <0) {
            System.out.println("学生1的年龄小于学生2");
        }
    }
}


