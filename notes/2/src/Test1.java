import java.util.ArrayList;
import java.util.List;

/**
 * @Description:  list 中存放的是学生类型
 * @Author: Cheng
 * @Create: 2020-05-13 17:46
 **/

class Student {
    private String name;
    private String grade;
    private int score;

    public Student(String name, String grade, int score) {
        this.name = name;
        this.grade = grade;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", score=" + score +
                '}';
    }
}
public class Test1 {

    public static void main(String[] args) {
        Student student1 =new Student("小明","一年级",90);
        Student student2 =new Student("小红","二年级",93);
        Student student3 =new Student("小李","三年级",99);

        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);

        System.out.println(list);


    }
}
