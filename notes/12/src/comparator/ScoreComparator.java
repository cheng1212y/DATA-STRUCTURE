package comparator;

import java.util.Comparator;

/**
 * @Description:   分数比较器
 * @Author: Cheng
 * @Create: 2020-05-27 15:11
 **/
public class ScoreComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.score-o2.score;
    }
}
