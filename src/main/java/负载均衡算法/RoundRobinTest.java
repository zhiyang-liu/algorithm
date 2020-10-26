package 负载均衡算法;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 轮询算法
 * Created by liuzhiyang on 2020/10/26 下午4:27
 */
public class RoundRobinTest {

    private static Map<String,Integer> ipMap = new HashMap<>();

    static {
        ipMap.put("192.168.13.1",1);
        ipMap.put("192.168.13.2",1);
        ipMap.put("192.168.13.3",1);

    }

    private static Integer  pos = 0;

    public String RoundRobin(){
        Map<String,Integer> ipServerMap = new HashMap<>();
        ipServerMap.putAll(ipMap);

        Set<String> ipSet = ipServerMap.keySet();

        ArrayList<String> ips = new ArrayList<>();
        ips.addAll(ipSet);

        String serverName = null;

        synchronized (pos) {
            if (pos >= ips.size()) {
                pos = 0;
            }
            serverName = ips.get(pos);
            pos ++;
        }

        return serverName;

    }

    public static void main(String[] args) {
        RoundRobinTest testRoundRobin = new RoundRobinTest();
        for (int i = 0; i < 10; i++) {
            String serverIp = testRoundRobin.RoundRobin();
            System.out.println(serverIp);
        }
    }

}
