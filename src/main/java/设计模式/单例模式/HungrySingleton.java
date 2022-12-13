package 设计模式.单例模式;

/**
 * 饿汉式（推荐）
 * 优点：无锁的线程安全；
 * 缺点：内存占用，没有使用就被加载到内存；反射可以改变私有构造函数来入侵；
 * Created by liuzhiyang on 2020/5/6 下午4:38
 */
public class HungrySingleton {

    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {}

    public static HungrySingleton getInstance() {
        return instance;
    }

}