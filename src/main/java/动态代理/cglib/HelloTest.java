package 动态代理.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * Created by liuzhiyang on 2020/12/2 下午7:19
 */
public class HelloTest {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloWorld.class);
        enhancer.setCallback(new HelloMethodInterceptor());
        HelloWorld helloWorld = (HelloWorld) enhancer.create();
        helloWorld.sayHelloWorld();
    }

}
