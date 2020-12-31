package 设计模式.工厂模式.抽象工厂;

import 设计模式.工厂模式.entity.Color;
import 设计模式.工厂模式.entity.Shape;

/**
 * Created by liuzhiyang on 2020/12/31 下午2:25
 */
public abstract class AbstractFactory {

    public abstract Color getColor(String color);

    public abstract Shape getShape(String shape) ;

}
