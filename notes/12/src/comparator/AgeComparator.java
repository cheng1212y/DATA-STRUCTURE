package comparator;

import java.util.Comparator;

/**
 * @Description:  自己实现的比较器
 * @Author: Cheng
 * @Create: 2020-05-27 15:01
 **/
public class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.age-o2.age;
    }
}
