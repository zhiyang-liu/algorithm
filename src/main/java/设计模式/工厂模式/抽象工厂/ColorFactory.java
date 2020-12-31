package 设计模式.工厂模式.抽象工厂;

import 设计模式.工厂模式.entity.Blue;
import 设计模式.工厂模式.entity.Color;
import 设计模式.工厂模式.entity.Green;
import 设计模式.工厂模式.entity.Red;
import 设计模式.工厂模式.entity.Shape;

/**
 * Created by liuzhiyang on 2020/12/31 下午2:27
 */
public class ColorFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType){
        return null;
    }

    @Override
    public Color getColor(String color) {
        if (color == null) {
            return null;
        }
        if (color.equalsIgnoreCase("RED")) {
            return new Red();
        } else if (color.equalsIgnoreCase("GREEN")) {
            return new Green();
        } else if (color.equalsIgnoreCase("BLUE")) {
            return new Blue();
        }
        return null;
    }

}
