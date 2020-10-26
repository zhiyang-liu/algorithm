package 负载均衡算法.平滑加权轮询;

/**
 * Created by liuzhiyang on 2020/10/26 下午5:38
 */
public class ServerInfo {

    private String ip;

    private Integer weight;

    private Integer current;

    public ServerInfo(String ip, Integer weight, Integer current) {
        this.ip = ip;
        this.weight = weight;
        this.current = current;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

}
