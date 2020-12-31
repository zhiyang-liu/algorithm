package 设计模式.工厂模式.抽象工厂;

import 设计模式.工厂模式.entity.Circle;
import 设计模式.工厂模式.entity.Color;
import 设计模式.工厂模式.entity.Rectangle;
import 设计模式.工厂模式.entity.Shape;
import 设计模式.工厂模式.entity.Square;

/**
 * Created by liuzhiyang on 2020/12/31 下午2:26
 */
public class ShapeFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType){
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }

    @Override
    public Color getColor(String color) {
        return null;
    }

}
