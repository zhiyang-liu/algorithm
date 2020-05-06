package 单例;

/**
 * 饿汉式（推荐）
 * Created by liuzhiyang on 2020/5/6 下午4:38
 */
public class HungrySingleton {

    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {}

    public static HungrySingleton getInstance() {
        return instance;
    }

}