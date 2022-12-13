package 动态代理.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * CGLib是针对类实现代理，对指定的类生成一个子类，并覆盖其中的方法，这种通过继承类的实现方式，不能代理final修饰的类
 * CGLib创建效率较低，执行效率高
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
