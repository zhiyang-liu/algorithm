package 设计模式.过滤器模式;

import java.util.List;

/**
 * Created by liuzhiyang on 2020/12/31 下午3:03
 */
public interface Criteria {

    List<Person> meetCriteria(List<Person> persons);

}
