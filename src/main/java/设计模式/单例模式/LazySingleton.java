package 设计模式.单例模式;

/**
 * 懒汉式
 * 优点：使用时才加载内存；
 * 缺点：有锁的线程安全；反射可以改变私有构造函数来入侵；
 * Created by liuzhiyang on 2020/5/6 下午4:36
 */
public class LazySingleton {

    /**
     * 假如有AB两个线程当A线程执行到代码1处的时候.这个语句不是一个原子操作.它实际上分为三个步骤
     * * 1…memory = allocate() //分配内存
     * * 2… ctorInstanc(memory) //初始化对象
     * * 3… instance = memory //设置instance指向刚分配的地址
     * 如果发生了指令重排,使得执行顺序变成了132,当执行完13之后,instance指向了类型了instance但是内容为空的对象.
     * 此时如果B线程执行到了代码2,因为instance不是null,程序会直接返回instance空的对象.所以我们加上了volatile避免了指令重排可以避免这样的情况发生.
     */
    private static LazySingleton instance = null;

    private LazySingleton() {}

    /**
     * 1、适用于单线程环境（不推荐）
     */
    public static LazySingleton getInstanceA() {
        if (null == instance) {
            instance = new LazySingleton();
        }
        return instance;
    }

    /**
     * 2、适用于多线程环境，但效率不高（不推荐）
     */
    public static synchronized LazySingleton getInstanceB() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    /**
     * 3、双重检查加锁（推荐）
     */
    public static LazySingleton getInstanceC() {
        // 先判断实例是否存在，若不存在再对类对象进行加锁处理
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }

}
