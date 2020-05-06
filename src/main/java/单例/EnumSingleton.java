package 单例;

/**
 * 枚举（推荐）
 * 创建枚举默认就是线程安全的，所以不需要担心double checked locking，
 * 而且还能防止反序列化导致重新创建新的对象。
 * 保证只有一个实例（即使使用反射机制也无法多次实例化一个枚举量）。
 *
 * 普通的Java类的反序列化过程中，会通过反射调用类的默认构造函数来初始化对象。
 * 枚举类型在序列化的时候Java仅仅是将枚举对象的name属性输出到结果中，
 * 反序列化的时候则是通过java.lang.Enum的valueOf方法来根据名字查找枚举对象。
 *
 * Created by liuzhiyang on 2020/5/6 下午4:52
 */
public class EnumSingleton {

    enum Single {
        SINGLE;

        private Single() {}

        public void print() {
            System.out.println("hello world");
        }
    }

    public static void main(String[] args) {
        Single single = Single.SINGLE;
        single.print();
    }
}
