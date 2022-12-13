package 动态代理.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * JDK动态代理机制是委托机制，具体说动态实现接口类，在动态生成的实现类里面委托hanlder去调用原始实现类方法
 * 创建代理对象效率较高，执行效率较低
 * Created by liuzhiyang on 2020/12/2 下午6:40
 */
public class PersonHandler implements InvocationHandler {

    private Object obj;

    public PersonHandler(Object obj) {
        this.obj = obj;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result = method.invoke(obj, args);
        System.out.println("after");
        return result;
    }

}
