package 设计模式.工厂模式.entity;

/**
 * Created by liuzhiyang on 2020/12/31 下午1:58
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }

}
