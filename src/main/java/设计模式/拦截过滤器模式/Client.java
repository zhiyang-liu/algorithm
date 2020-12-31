package 设计模式.拦截过滤器模式;

/**
 * Created by liuzhiyang on 2020/12/31 下午4:12
 */
public class Client {

    FilterManager filterManager;

    public void setFilterManager(FilterManager filterManager) {
        this.filterManager = filterManager;
    }

    public void sendRequest(String request) {
        filterManager.filterRequest(request);
    }

}
