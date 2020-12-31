package 设计模式.过滤器模式;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuzhiyang on 2020/12/31 下午3:05
 */
public class CriteriaSingle implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> singlePersons = new ArrayList<>();
        for (Person person : persons) {
            if (person.getMaritalStatus().equalsIgnoreCase("SINGLE")) {
                singlePersons.add(person);
            }
        }
        return singlePersons;
    }

}
