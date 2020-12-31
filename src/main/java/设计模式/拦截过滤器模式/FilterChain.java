package 设计模式.拦截过滤器模式;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuzhiyang on 2020/12/31 下午4:09
 */
public class FilterChain {

    private List<Filter> filters = new ArrayList<>();
    private Target target;

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    public void execute(String request) {
        for (Filter filter : filters) {
            filter.execute(request);
        }
        target.execute(request);
    }

    public void setTarget(Target target) {
        this.target = target;
    }

}
