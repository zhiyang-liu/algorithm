package 设计模式.拦截过滤器模式;

/**
 * Created by liuzhiyang on 2020/12/31 下午4:08
 */
public class Target {

    public void execute(String request) {
        System.out.println("Executing request: " + request);
    }

}
