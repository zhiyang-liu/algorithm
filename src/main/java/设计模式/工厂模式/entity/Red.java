package 设计模式.工厂模式.entity;

/**
 * Created by liuzhiyang on 2020/12/31 下午2:22
 */
public class Red implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }

}
