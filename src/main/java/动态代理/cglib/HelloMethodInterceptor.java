package 动态代理.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by liuzhiyang on 2020/12/2 下午7:14
 */
public class HelloMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before" + " " + method.getName());
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("after" + " " + method.getName());
        return object;
    }

}
