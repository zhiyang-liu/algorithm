package 观察者;

public class Emp implements Weather {

	String name;

	public Emp(String name) {
		this.name = name;
	}

	// 根据天气计划任务  "晴天","阴天","下雨","冰雹","下雪"
	@Override
	public void doByWeather(String weather) {
		if ("晴天".equals(weather)) {
			System.out.println("晴天，出去郊游！");
		} else if ("阴天".equals(weather)) {
			System.out.println("阴天，看电视！");
		} else if ("下雨".equals(weather)) {
			System.out.println("下雨，睡觉！");
		} else if ("冰雹".equals(weather)) {
			System.out.println("冰雹，不要出屋！");
		} else if ("下雪".equals(weather)){
			System.out.println("下雪，打雪仗！");
		} else {
			System.out.println("出错了！！！");
		}
	}

}
