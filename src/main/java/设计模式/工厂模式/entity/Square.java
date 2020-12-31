package 设计模式.工厂模式.entity;

/**
 * Created by liuzhiyang on 2020/12/31 下午1:59
 */
public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }

}
