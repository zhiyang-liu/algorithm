package 设计模式.过滤器模式;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuzhiyang on 2020/12/31 下午3:04
 */
public class CriteriaFemale implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> femalePersons = new ArrayList<Person>();
        for (Person person : persons) {
            if (person.getGender().equalsIgnoreCase("FEMALE")) {
                femalePersons.add(person);
            }
        }
        return femalePersons;
    }

}
