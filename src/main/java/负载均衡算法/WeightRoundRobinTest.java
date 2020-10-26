package 负载均衡算法;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 加权轮询算法
 * Created by liuzhiyang on 2020/10/26 下午4:33
 */
public class WeightRoundRobinTest {

    private static Map<String,Integer> ipMap = new HashMap<>();

    static {
        ipMap.put("192.168.13.1",1);
        ipMap.put("192.168.13.2",2);
        ipMap.put("192.168.13.3",4);


    }

    private static Integer pos = 0;

    public String weightRoundRobin() {
        Map<String,Integer> ipServerMap=new HashMap<>();
        ipServerMap.putAll(ipMap);

        Set<String> ipSet=ipServerMap.keySet();

        ArrayList<String> ips = new ArrayList<>();

        Iterator<String> ipIterator = ipSet.iterator();
        while (ipIterator.hasNext()) {
            String serverName = ipIterator.next();
            Integer weight = ipServerMap.get(serverName);
            for (int i = 0; i < weight; i++) {
                ips.add(serverName);
            }
        }

        String serverName = null;
        synchronized (pos) {
            if (pos >= ips.size()) {
                pos = 0;
            }
            serverName = ips.get(pos);
            pos ++;
        }

        return  serverName;
    }

    public static void main(String[] args) {
        WeightRoundRobinTest testWeightRoundRobin = new WeightRoundRobinTest();
        for (int i = 0; i < 10; i++) {
            String server = testWeightRoundRobin.weightRoundRobin();
            System.out.println(server);
        }
    }

}
