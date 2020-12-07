package 动态代理.jdk;

/**
 * Created by liuzhiyang on 2020/12/2 下午6:40
 */

public class PersonDaoImpl implements PersonDao {

    @Override
    public void say() {
        System.out.println("time to eat");
    }

}
