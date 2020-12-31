package 设计模式.拦截过滤器模式;

/**
 * Created by liuzhiyang on 2020/12/31 下午4:11
 */
public class FilterManager {

    FilterChain filterChain;

    public FilterManager(Target target) {
        filterChain = new FilterChain();
        filterChain.setTarget(target);
    }
    public void setFilter(Filter filter) {
        filterChain.addFilter(filter);
    }

    public void filterRequest(String request) {
        filterChain.execute(request);
    }

}
