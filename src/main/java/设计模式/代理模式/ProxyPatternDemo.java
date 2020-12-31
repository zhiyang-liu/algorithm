package 设计模式.代理模式;

/**
 * Created by liuzhiyang on 2020/12/31 下午3:16
 */
public class ProxyPatternDemo {

    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");

        // 图像将从磁盘加载
        image.display();
        // 图像不需要从磁盘加载
        image.display();
    }

}
