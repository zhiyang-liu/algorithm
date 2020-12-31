package 设计模式.工厂模式.简单工厂;

import 设计模式.工厂模式.entity.Circle;
import 设计模式.工厂模式.entity.Rectangle;
import 设计模式.工厂模式.entity.Shape;
import 设计模式.工厂模式.entity.Square;

/**
 * 简单工厂模式
 * Created by liuzhiyang on 2020/12/31 下午2:00
 */
public class ShapeFactory {

    public static Shape getShape(String shapeType) {
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

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        // 获取 Circle 的对象，并调用它的 draw 方法
        Shape shape1 = shapeFactory.getShape("CIRCLE");

        // 调用 Circle 的 draw 方法
        shape1.draw();

        // 获取 Rectangle 的对象，并调用它的 draw 方法
        Shape shape2 = shapeFactory.getShape("RECTANGLE");

        // 调用 Rectangle 的 draw 方法
        shape2.draw();

        // 获取 Square 的对象，并调用它的 draw 方法
        Shape shape3 = shapeFactory.getShape("SQUARE");

        // 调用 Square 的 draw 方法
        shape3.draw();
    }

}
