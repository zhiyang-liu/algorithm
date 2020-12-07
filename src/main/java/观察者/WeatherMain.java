package 观察者;

public class WeatherMain {

	public static void main(String[] args) {
		Emp emp1 = new Emp("小明");
		Emp emp2 = new Emp("如花");
		Emp emp3 = new Emp("刘星");

		WeatherStation weatherStation = new WeatherStation();
		weatherStation.addObject(emp1);
		weatherStation.addObject(emp2);
		weatherStation.addObject(emp3);

		weatherStation.startWork();
	}

}
