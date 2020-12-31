package 设计模式.过滤器模式;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuzhiyang on 2020/12/31 下午3:03
 */
public class CriteriaMale implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> malePersons = new ArrayList<>();
        for (Person person : persons) {
            if (person.getGender().equalsIgnoreCase("MALE")) {
                malePersons.add(person);
            }
        }
        return malePersons;
    }

}
