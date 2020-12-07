package 观察者;

import java.util.ArrayList;
import java.util.Random;

public class WeatherStation {

    // 定义天气数组，存储天气种类。
    String[] weathers={"晴天","阴天","下雨","冰雹","下雪"};

    // 当前天气
    String weather;

    // 集合中维护了一个接口，来存储要获得天气的对象，必须实现接口才能添加到集合。
    ArrayList<Weather> list = new ArrayList<>();

    // 添加对象向集合中。
    public void addObject(Weather e) {
        list.add(e);
    }

    Random random = new Random();

    public void startWork() {
        while(true) {
            new Thread(){
                @Override
                public void run() {
                    // 每1-1.5秒获得一次天气
                    int time = random.nextInt(501) + 1000;
                    try {
                        Thread.sleep(time);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    weatherUpdate();
                    for (Weather e : list) {
                        e.doByWeather(weather);
                    }
                }
            }.start();
        }
    }

    // 获取天气。
    public void weatherUpdate() {
        int index = random.nextInt(weathers.length);
        weather = weathers[index];
        System.out.println("当前天气是：" + weather);
    }

}
