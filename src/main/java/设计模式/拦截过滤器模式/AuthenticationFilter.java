package 设计模式.拦截过滤器模式;

/**
 * Created by liuzhiyang on 2020/12/31 下午4:05
 */
public class AuthenticationFilter implements Filter {

    public void execute(String request) {
        System.out.println("Authenticating request: " + request);
    }

}
