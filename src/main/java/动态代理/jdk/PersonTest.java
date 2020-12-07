package 动态代理.jdk;

import java.lang.reflect.Proxy;

/**
 * Created by liuzhiyang on 2020/12/2 下午6:44
 */
public class PersonTest {

    public static void main(String[] args) {
        PersonDao pDao = new PersonDaoImpl();
        PersonHandler handler = new PersonHandler(pDao);

        PersonDao proxy = (PersonDao) Proxy.newProxyInstance(pDao.getClass().getClassLoader(), pDao.getClass().getInterfaces(), handler);
        proxy.say();
    }

}
